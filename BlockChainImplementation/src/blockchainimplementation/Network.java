/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author johnny
 */
public class Network {
    private PrincipalNode pNode;
    private Nodo[] nodes;
    private Thread[] threads;
    
    public Network(PrincipalNode pNode, Nodo[] nodes){
        this.pNode =  new PrincipalNode(nodes);
        this.nodes = nodes;
        threads = new Thread[nodes.length];
    }
    
    public void init(String data, String previousHash) throws IOException{
        pNode.sendBlock(data, previousHash);
        FileWriter fw = new FileWriter("low_node_2_5.csv", true);
        PrintWriter pw = new PrintWriter(fw);
        prepareThreads();
        long start = System.currentTimeMillis();
        startThreads();
        waitThreads();
        
//        double average_calcs = getAverageCalcs();
        
        Nodo b = pNode.decideWinner();
        int tries = 1;
        while(b == null && tries < 10) {
            tries++;
            prepareThreads();
            startThreads();
            waitThreads();
            b = pNode.decideWinner();
        }
        if (b != null) {
            for(Nodo node: nodes) {
                node.receiveWinner(b.getMiner().getBlock());
            }
            long end = System.currentTimeMillis();
            System.out.println("Tiempo pasado: " + (end-start));
            pw.println(String.format("%d,%d,%d", nodes.length, tries,b.getMiner().getId()));
        } else {
            pw.println(String.format("%d,%d,%d", nodes.length, tries,0));
        }
        pw.close();
        fw.close();
    }
    
    private void prepareThreads(){
        for(int i = 0; i < nodes.length; i++){
            threads[i] = nodes[i].mineBlockThread();
        }
    }
    
    private double getAverageCalcs() {
        double calcs = 0;
        for (Nodo node : nodes) {
            calcs += node.getMiner().getBlock().getIterations();
        }
        return calcs/nodes.length;
    }
    
    private void startThreads(){
        for(Thread t: threads){
            t.start();
        }
    }
    
    private void waitThreads(){
        for(Thread t: threads){
            try{
                t.join();
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

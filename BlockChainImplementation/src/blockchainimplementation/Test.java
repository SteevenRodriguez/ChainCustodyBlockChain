/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnny
 */
public class Test {
    private int numNodes;
    private String data;
    private String prevHash;
    private Network network;
    
    public Test(int numNodes, String data, String previousHash){
        this.numNodes = numNodes;
        this.data = data;
        prevHash = previousHash;
    }
    
    public void runTest() throws IOException{
        prepare();
        network.init(data, prevHash);
    }
    
    /*public final void init(String data, String previousHash, long challenge){
        for(int i = 0; i < miners.length; i++){  
            miners[i] = new Nodo();
            miners[i].setMiningBlock(new Block(data, previousHash, challenge));
        }
    }*/
    
    private void prepare(){
        Nodo[] nodes = new Nodo[numNodes];
        long threshold = getThreshold();
        nodes[0] = new Nodo(1, threshold/3);
        for(int i = 1; i < nodes.length; i++){
            nodes[i] = new Nodo(i+1, threshold);
        }
        PrincipalNode pNode = new PrincipalNode(nodes);
        network = new Network(pNode, nodes);
        
    }
    
    private long getThreshold() {
        long threshol = 7000000;
        try {
            Scanner scan = new Scanner(new File("process_means.csv"));
            while (scan.hasNext()) {
                String[] line = scan.nextLine().split(",");
                if (Integer.parseInt(line[0]) == numNodes) {
                    return (long)Double.parseDouble(line[1]);
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return threshol;
    }
    /*
    public BlockMiner[] getMiners(){
        return miners;
    }
    
    public void addMiner(BlockMiner miner){
        miners[index++] = miner; //posible outofbounds
    }
    
    public void run(){
        for(BlockMiner miner: miners){
            new Thread(miner).start();
        }
    }*/
}

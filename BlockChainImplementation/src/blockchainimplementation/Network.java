/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;

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
    
    public void init(String data, String previousHash){
        pNode.sendBlock(data, previousHash);
        
        prepareThreads();
        long start = System.currentTimeMillis();
        startThreads();
        waitThreads();
        
        Block b = pNode.decideWinner();
        for(Nodo node: nodes){
            node.receiveWinner(b);
        }
        long end = System.currentTimeMillis();
        System.out.println("Tiempo pasado: " + (end-start));
    }
    
    private void prepareThreads(){
        for(int i = 0; i < nodes.length; i++){
            threads[i] = nodes[i].mineBlockThread();
        }
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

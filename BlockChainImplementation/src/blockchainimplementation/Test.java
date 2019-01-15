/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;

import java.io.IOException;

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
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Nodo(i+1);
        }
        PrincipalNode pNode = new PrincipalNode(nodes);
        network = new Network(pNode, nodes);
        
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

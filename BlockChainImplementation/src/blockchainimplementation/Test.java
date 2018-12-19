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
public class Test {
    private BlockMiner[] miners;
    private int index;
    
    public Test(int blocks){
        miners = new BlockMiner[blocks];
    }
    
    /*private final void init(){
        for(int i =0; i < miners.length; i++){
            
            miners[i] = new BlockMiner();
        }
    }*/
    
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
    }
}

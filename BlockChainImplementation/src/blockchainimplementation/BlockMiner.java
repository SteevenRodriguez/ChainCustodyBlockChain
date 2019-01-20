/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;

import java.math.BigInteger;

/**
 *
 * @author johnny
 */
public class BlockMiner implements Runnable{
    private Block block;
    private int id;
    private long threshold;
    
    public BlockMiner(int id){
        this.id = id;
        this.threshold = 0;
    }
    
    public BlockMiner(int id, long threshol){
        this.id = id;
        this.threshold = threshol;
    }
    
    public BlockMiner(Block block){
        this.block = block;
    }
    
    public void setBlock(Block block){
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
    
    public int getId(){
        return id;
    }

    @Override
    public void run() {
        BigInteger b = block.mineBlock(threshold);
        System.out.println(String.format("Block Mined!\nHash: %s\nNodeID: %d", block.hash, id));
    }
    
    
}

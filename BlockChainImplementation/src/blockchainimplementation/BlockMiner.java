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
public class BlockMiner implements Runnable{
    private Block block;
    
    public BlockMiner(){
        
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
    
    

    @Override
    public void run() {
        block.mineBlock();
    }
    
    
}

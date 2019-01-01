/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;

import java.util.ArrayList;

/**
 *
 * @author johnny
 */
public class Nodo {
    private BlockMiner miner;
    private ArrayList<Block> blockchain;
    public long challenge;
    
    public Nodo(){
        blockchain = new ArrayList<>();
        miner = new BlockMiner();
    }
    
    public boolean isChainValid() {
	Block currentBlock; 
	Block previousBlock;
	
	//loop through blockchain to check hashes:
	for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                    System.out.println("Current Hashes not equal");			
                    return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                    System.out.println("Previous Hashes not equal");
                    return false;
            }
	}
	return true;
    }
    
    public ArrayList<Block> getBlockchain(){
        return blockchain;
    }
    public void setMiningBlock(Block block){
        challenge = block.getMasterNonce();
        
        miner.setBlock(block);
    }

    public BlockMiner getMiner() {
        return miner;
    }
    
    public void receiveWinner(Block winner){
        int winnerSize = StringUtil.stringSize(winner.hash);
        if(winnerSize > challenge){
            //not altered
            blockchain.add(winner);
        }
    }
    
    public Thread mineBlockThread(){
        return new Thread(miner);
    }
    
}

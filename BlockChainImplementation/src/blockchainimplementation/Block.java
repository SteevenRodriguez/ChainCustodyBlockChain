/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;
/**
 *
 * @author steevenrodriguez
 */
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // Cualquier objeto
    private long timeStamp;
    private long masterNonce;
    private long nonce;

    //Block Constructor.
    public Block(String data, String previousHash, long masterNonce) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.nonce = (long)(Math.random() * Math.pow(2, 32));
        this.masterNonce = masterNonce;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash + timeStamp + data + masterNonce + nonce);
        return calculatedhash;

    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }
    
    public int mineBlock() {
        int currentHashSize = StringUtil.stringSize(hash);
        long start = System.currentTimeMillis();
        long now = start;
        while(now - start < 60000){
            ++nonce;
            String tempHash = calculateHash();
            int tempHashSize = StringUtil.stringSize(tempHash);
            if(currentHashSize < tempHashSize){
                currentHashSize = tempHashSize;
                hash = tempHash;
            }
            now = System.currentTimeMillis();
        }
        System.out.println(String.format("Block Mined!\nHash: %s\nHash Size: %d", hash, currentHashSize));
        return currentHashSize;
    }
        
}
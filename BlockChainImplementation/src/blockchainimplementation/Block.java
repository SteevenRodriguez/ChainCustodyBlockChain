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
    
    private static int MIN = 1;
    private static int MAX = 1000000;
    //Block Constructor.
    public Block(String data, String previousHash, long masterNonce) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.nonce = (long)(Math.random()* (MAX - MIN) + MIN);
        this.masterNonce = masterNonce;
        this.hash = calculateHash(nonce);
    }

    public String calculateHash(long nonce) {
        String calculatedhash = StringUtil.applySha256(
                previousHash + timeStamp + data + masterNonce + nonce);
        return calculatedhash;

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

    public long getMasterNonce() {
        return masterNonce;
    }
    
    public int mineBlock() {
        int currentHashSize = StringUtil.stringSize(hash);
        long start = System.currentTimeMillis();
        long now = start;
        long tempNonce = nonce;
        while(now - start < 60000){
            tempNonce++;        
            String tempHash = calculateHash(tempNonce);
            int tempHashSize = StringUtil.stringSize(tempHash);
            if(currentHashSize < tempHashSize){
                currentHashSize = tempHashSize;
                hash = tempHash;
                nonce = tempNonce;
            }
            now = System.currentTimeMillis();
        }
        System.out.println(String.format("Block Mined!\nHash: %s\nHash Size: %d", hash, currentHashSize));
        return currentHashSize;
    }
        
}
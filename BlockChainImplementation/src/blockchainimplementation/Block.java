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
import java.math.BigInteger;
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // Cualquier objeto
    private long timeStamp;
    private BigInteger masterNonce;
    private BigInteger nonce;
    private static int MIN = 1;
    private static int MAX = 10000;
    //Block Constructor.
    public Block(String data, String previousHash, BigInteger masterNonce) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.nonce = StringUtil.random();
        this.masterNonce = masterNonce;
        this.hash = calculateHashWithoutNonce();
    }

    public String calculateHash(BigInteger nonce) {
        String calculatedhash = StringUtil.applySha256(
                previousHash + timeStamp + data + masterNonce + nonce);
        return calculatedhash;

    }
    
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash + timeStamp + data + masterNonce + nonce);
        return calculatedhash;

    }
    
    public String calculateHashWithoutNonce(){
        String calculatedhash = StringUtil.applySha256(
                previousHash + timeStamp + data + masterNonce);
        return calculatedhash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public BigInteger getNonce() {
        return nonce;
    }

    public void setNonce(BigInteger nonce) {
        this.nonce = nonce;
    }

    public BigInteger getMasterNonce() {
        return masterNonce;
    }
    
    public BigInteger mineBlock() {
        BigInteger one = new BigInteger("1");
        BigInteger currentHashSize = StringUtil.stringSize(hash);
        BigInteger tempHashSize;
        long start = System.currentTimeMillis();
        long now = start;
        BigInteger tempNonce = nonce;
        while(now - start < 60000){
            tempNonce = tempNonce.add(one);
            String tempHash = calculateHash(tempNonce);
            tempHashSize = StringUtil.stringSize(tempHash);
            if(currentHashSize.compareTo(tempHashSize) < 0){
                currentHashSize = tempHashSize;
                hash = tempHash;
                nonce = tempNonce;
            }
            now = System.currentTimeMillis();
        }
        
        return currentHashSize;
    }
        
}
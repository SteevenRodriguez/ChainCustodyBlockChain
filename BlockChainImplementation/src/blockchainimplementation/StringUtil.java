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
import java.security.MessageDigest;
import java.security.SecureRandom;

public class StringUtil {
    //Applies Sha256 to a string and returns the result. 
    public static String applySha256(String input){		
        try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
                //Applies sha256 to our input, 
                byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
                StringBuffer hexString = new StringBuffer();
                for (int i = 0; i < hash.length; i++) {
                        String hex = Integer.toHexString(0xff & hash[i]);
                        if(hex.length() == 1) hexString.append('0');
                        hexString.append(hex);
                }
                return hexString.toString();
        }
        catch(Exception e) {
                throw new RuntimeException(e);
        }
    }	
    
    /**
     * 
     * @param s
     * @return Size of string
     */
    /*public static int stringSize(String s){
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            size += charNum(s.charAt(i));
        }
        return size;
    }*/
    
    public static BigInteger stringSize(String s){
        BigInteger size = new BigInteger(s, 16);
        return size;
    }
    
    public static BigInteger random(){
        BigInteger sn = new BigInteger(32, new SecureRandom());
        return sn;
    }
    
    public static String randomHex(){
        BigInteger sn = new BigInteger(256, new SecureRandom());
        return sn.toString(16);
    }
}

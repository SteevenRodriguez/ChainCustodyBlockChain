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
public class PrincipalNode {
    
    public int makeChallenge(){
        return (int)(Math.random() * 5000 + 1000);
    }
}

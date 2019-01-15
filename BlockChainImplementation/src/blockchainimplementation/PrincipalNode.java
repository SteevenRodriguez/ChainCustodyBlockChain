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
public class PrincipalNode {
    private Nodo[] nodes;
    private static int MIN = 5300;
    private static int MAX = 5500;
    public PrincipalNode(Nodo[] nodes){
        this.nodes = nodes;
    }
    private BigInteger makeChallenge(){
        
        return StringUtil.random();
    }
    
    public void sendBlock(String data, String previousHash){
        BigInteger masterNonce = makeChallenge();
        
        for(Nodo node: nodes){
            Block b = new Block(data, previousHash, masterNonce);
            node.setMiningBlock(b);
        }
    }
    
    public Nodo decideWinner(){
        Nodo winnerNode = null;
        Nodo maxNode = nodes[0];
        Block max = nodes[0].getMiner().getBlock();
        BigInteger maxSize = new BigInteger("0");
        for(int i = 1; i < nodes.length; i++){
            Block b = nodes[i].getMiner().getBlock();
            BigInteger bSize = StringUtil.stringSize(b.hash);
            maxSize = StringUtil.stringSize(max.hash);
            if(bSize.compareTo(maxSize) > 0){
                max = b;
                maxSize = bSize;
                maxNode = nodes[i];
            }
        }//found max value

        if(maxSize.compareTo(nodes[0].challenge) > 0){
            winnerNode = maxNode;
            System.out.println("Winner is: " + winnerNode.getMiner().getId());
        }
        return winnerNode;
    }
}

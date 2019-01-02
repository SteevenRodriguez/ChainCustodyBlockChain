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
    private Nodo[] nodes;
    private static int MIN = 5300;
    private static int MAX = 5500;
    public PrincipalNode(Nodo[] nodes){
        this.nodes = nodes;
    }
    private long makeChallenge(){
        return (long)(Math.random() * (MAX - MIN) + MIN);
    }
    
    public void sendBlock(String data, String previousHash){
        long challenge = makeChallenge();
        System.out.println("Challenge is: " + challenge);
        for(Nodo node: nodes){
            Block b = new Block(data, previousHash, challenge);
            node.setMiningBlock(b);
        }
    }
    
    public Block decideWinner(){
        Block winner = null;
        Block max = nodes[0].getMiner().getBlock();
        int maxSize = 0;
        for(int i = 1; i < nodes.length; i++){
            Block b = nodes[i].getMiner().getBlock();
            int bSize = StringUtil.stringSize(b.hash);
            maxSize = StringUtil.stringSize(max.hash);
            if(bSize > maxSize){
                max = b;
                maxSize = bSize;
            }
        }//found max value
        System.out.println("max size is: " + maxSize);
        if(maxSize > nodes[0].challenge){
            winner = max;
            System.out.println("Winner is: " + winner.hash);
        }
        return winner;
    }
}

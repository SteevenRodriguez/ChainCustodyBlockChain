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
    
    public PrincipalNode(Nodo[] nodes){
        this.nodes = nodes;
    }
    private long makeChallenge(){
        return (long)(Math.random() * 5000 + 1000);
    }
    
    public void sendBlock(String data, String previousHash){
        long challenge = makeChallenge();
        for(Nodo node: nodes){
            Block b = new Block(data, previousHash, challenge);
            node.setMiningBlock(b);
        }
    }
    
    public Block decideWinner(){
        Block winner = nodes[0].getMiner().getBlock();
        for(int i = 1; i < nodes.length; i++){
            Block b = nodes[i].getMiner().getBlock();
            int winnerSize = StringUtil.stringSize(winner.hash);
            int bSize = StringUtil.stringSize(b.hash);
            if(bSize > winnerSize)
                winner = b;
        }
        System.out.println("Winner is: " + winner.hash);
        return winner;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainimplementation;


import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author johnny
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Nodo n1 = new Nodo();
        ArrayList<Block> blockchain = n1.getBlockchain();
        
        blockchain.add(new Block("Genesis", "0"));
		System.out.println("Trying to Mine block 1... ");
		System.out.print(blockchain.get(0).mineBlock());
		
		blockchain.add(new Block("Luis",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		System.out.print(blockchain.get(1).mineBlock());
		
		/*blockchain.add(new Block("Miguel",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(5);	*/
		
		/*System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);*/
        Block block = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf"); //for demonstration purposes only
        Block block2 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
        Block block3 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
        Block block4 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
        Block block5 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
        Test test = new Test(5);
        test.addMiner(new BlockMiner(block));
        test.addMiner(new BlockMiner(block2));
        test.addMiner(new BlockMiner(block3));
        test.addMiner(new BlockMiner(block4));
        test.addMiner(new BlockMiner(block5));
        test.run();
        /*
            Aqui hay un problema. bloque tiene 
        */
    }
}

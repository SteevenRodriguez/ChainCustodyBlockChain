
package blockchainimplementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author johnny
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, 
            IOException {
        /*
        Random ran = new Random();
        FileWriter fw = new FileWriter("results.csv", true);
        PrintWriter pw = new PrintWriter(fw);
        
        for (int i = 1; i <= 50; i++) {      
            int nBlocks = 3 + ran.nextInt(10-3+1);
            Block[] blocks = new Block[nBlocks];
            for (int x = 0; x < nBlocks; x++)
                blocks[x] = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
            Test test = new Test(nBlocks);
            for (Block block : blocks)
                test.addMiner(new BlockMiner(block));
            long start = System.currentTimeMillis();
            test.run();
            for (BlockMiner blockMiner : test.getMiners())
                blockMiner.join();
            long stop = System.currentTimeMillis();
            pw.println(String.format("%d,%d", nBlocks, stop-start));
        }*/
        Test test = new Test(5, "Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
        test.runTest();
       // pw.close();
        //fw.close();
        
//        Block block = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf"); //for demonstration purposes only
//        Block block2 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
//        Block block3 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
//        Block block4 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
//        Block block5 = new Block("Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
//        Test test = new Test(5);
//        test.addMiner(new BlockMiner(block));
//        test.addMiner(new BlockMiner(block2));
//        test.addMiner(new BlockMiner(block3));
//        test.addMiner(new BlockMiner(block4));
//        test.addMiner(new BlockMiner(block5));
//        long start = System.currentTimeMillis();
//        test.run();
//        for (BlockMiner blockMiner : test.getMiners()) {
//            blockMiner.join();
//        }
//        long stop = System.currentTimeMillis();
//        System.out.println(String.format("Tiempo demorado en ms: %d", stop-start));        
    }
}

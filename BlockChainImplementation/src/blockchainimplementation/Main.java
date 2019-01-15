
package blockchainimplementation;

import java.io.IOException;

/**
 *
 * @author johnny
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Test test = null;
        for(int numNodes = 2; numNodes < 3; numNodes++){
            for(int times = 0; times < 10; times++){
                System.out.println("INTENTO " + times +" CON " + numNodes + " NODOS");
                test = new Test(numNodes, "Random Data", "3c8cedbbbb9fa2c9fd9d54cffb4cacacb6add90bebade437ccadd1e4bfee2faf");
                test.runTest();
            }
        }
    }
}

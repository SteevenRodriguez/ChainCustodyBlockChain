
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
        for(int numNodes = 2; numNodes < 6; numNodes++){
            for(int times = 0; times < 100; times++){
                System.out.println("INTENTO " + (times+1) +" CON " + numNodes + " NODOS");
                test = new Test(numNodes, "Random Data", StringUtil.randomHex());
                test.runTest();
            }
        }
    }
}

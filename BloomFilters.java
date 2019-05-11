//************************************** */
//******** BLOOM FILTERS **************/
// Kyler Kopacz, Jack Fergus, and Dylan Finazzo
//************************************** */
import java.util.*;
//************************************** */
public class BloomFilters {
    //************************************** */
    /* GLOBALS */
    //************************************** */
    private static int[] A; //the bit Array
    private static int n; // size of bit array
    // private static {hash functions} h;
    private static int k; // number of hash functions
    private static double[] fpRates;
    //************************************** */


    public static void main(String[] args){
        int x = 1; // set this equal to the number of trials we want to run
        fpRates = new double[x];
        double rate = 1.0;
        int[] arraySizes = new int[x];
        
        // Fill an array with different number of bitArray sizes
        // Also can make array of number of hash functions in this loop
        for(int i = 0; i < x; i++){
            arraySizes[i] = 10000 * (i+1);
        }
        // run trials
        for(int j = 0; j < x; j++){
            n = arraySizes[j];
            A = new int[n];
            // h = new {hash functions}[k]; idk how we want to do this part
            A = init(A);
            rate = 0.0; // change to calculate rate of false positives // get from trial()
            fpRates[j] = rate;
        }

    }

    public static int[] initArray(int[] a){
        // Initialize array a
        // Need hash functions to do this part

        /*
        for i = 1...k
            set a[hi(x)] = 1
        */

        return a;
    }
    public static int trial(){ // fill in parenthesis
        /*
        for i = 1...k
            if A[hi(x)] = 0
                return false
        return true
        */

        return 0;
    }
}

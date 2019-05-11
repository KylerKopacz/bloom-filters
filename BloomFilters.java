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
    // Instead of a list, should we make each hash function its own method?
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
        for(int j = 0; j < x; j++){ // call trial() in here (also put something between parenthesis)
            n = arraySizes[j];
            A = new int[n];
            // h = new {hash functions}[k]; idk how we want to do this part
            A = init(A);
            rate = trial(1); // change trial input, need to pass itemset to check
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
    public static double trial(int rp){ // fill in more inputs--itemset to check
        //rp is nummber of actual positives
        int n = 0; // number of items we want to check
        int pos = 0; // number of "returned" positives
        
        for(int j = 0; j < n; j++){
            String s = ""; // or int i = 0; depending on what we're hashing
            if(lookup(s)){ // or lookup(i) if using ints ^^
                pos++;
            }
        }
        int x = 1;//temporary- represents size of itemset
        return ((pos-rp)/x); // number of "positives" -- I think this gives us fp rate?
    }
    public static boolean lookup(String s){
     /*
        for i = 1...k
            if A[hi(x)] = 0
                return false
        return true
        */   
    }
    public static boolean lookup(int i){
     /*
        for i = 1...k
            if A[hi(x)] = 0
                return false
        return true
        */   
    }
}

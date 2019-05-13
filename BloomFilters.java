//************************************** */
//******** BLOOM FILTERS **************/
// Kyler Kopacz, Jack Fergus, and Dylan Finazzo
//************************************** */
import java.util.*;
//************************************** */
public class BloomFilters {
    //************************************** */
    /* FIELDS */
    //************************************** */
    static int num_insertions = 1000;
    static int insertion_range = 100000;
    int[] A; //the bit Array
    int k; // number of hash functions
    int size; // size of the bit array
    HashSet actual; //Set of elements actually added to filter

    public BloomFilters(int num, int s){
        k = num;
        A = new int[s];
        size = s;
        actual = new HashSet();
    }
    //************************************** */

    public static void main(String[] args){

        int k = Integer.parseInt(args[0]); // Number of hash functions
        int size = Integer.parseInt(args[1]); // Size of the bit array
        
        BloomFilters filter = new BloomFilters(k, size);
        Random rand = new Random();

        for(int i=0; i<num_insertions; i++){
            int x = rand.nextInt(insertion_range); 
            filter.insert(x); //Insert random numbers between 0 and insertion_range
        }
        System.out.println(filter.fpRate(1000));
    }

    public void insert(int n){

        actual.add(n); // Add the inserted element to a hashset for false positive checking

        Random rand = new Random(n); //Generate random generator with a seed of the number inserted
        // for k hash functions, generate random numbers within the range of our "bit" array (acts as hash function)
        for(int i=0; i<k; i++){
            int index = rand.nextInt(size); 
            A[index] = 1; //set bits to 1
        }
    }

    public boolean lookup(int n){
    
        boolean toReturn = true;
        Random rand = new Random(n); //Random generator with the same seed will return same sequence of numbers
        
        for(int i=0; i<k; i++){
            int index = rand.nextInt(size); //Corresponds to the indices of the bit array that would
            if(A[index]==0){                //be set if the element was inserted, based on number of hashes
                toReturn = false; //If any of the bits are 0 the element was not added to the filter
            }
        }
        return toReturn;
    }

    public double fpRate(int num){

        int total_negatives = 0; //False positives + true negatives
        int fp = 0; //false positives

        Random rand = new Random();

        for(int i=0; i<num; i++){
            int trial = insertion_range + rand.nextInt(insertion_range); //Randomly generate ints that were not inserted
            if(!actual.contains(trial)){ // If the trial element was not inserted
                total_negatives++;
                if(lookup(trial)){ //If the filter says that the element is in the set
                    fp++;
                }
            }
        }
        return (double)fp/(double)total_negatives; //False positive rate
    }
}







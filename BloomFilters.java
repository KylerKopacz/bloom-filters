/** 
* Bloom Filter Simulation
* @author Dylan Finazzo
* @author Kyler Kopacz
* @author Jack Fergus
*/
import java.util.*;

/**
* Object Representation of a Bloom Filter.
* The main method is also the runner for the experiment.
*/
public class BloomFilters {
    /** Number of insertions to perform */
    static int num_insertions = 1000;
    
    /** Range for numbers to be inserted */
    static int insertion_range = 100000;
    
    /** The "bitset". */
    int[] A;
    
    /** Number of hash functions being used. */
    int k; 
    
    /** Size of the bitset. */
    int size;
    
    /** Hash set of all numbers that are actually added to the filter. */
    HashSet<Integer> actual;
    
    /**
    * Constructor to make a Bloom Filter Object.
    * @param num Number of hash functions for this filter.
    * @param size Size of the bitset for the filter.
    */
    public BloomFilters(int num, int size){
        k = num;
        this.size = size;
        A = new int[size];
        actual = new HashSet<Integer>();
    }
    
    /**
    * Insert an element into the bloom filter.
    * @param n The element to be inserted.
    */
    public void insert(int n) {
        
        // Add the inserted element to a hashset for false positive checking
        actual.add(n); 
        
        //Generate random generator with a seed of the number inserted
        Random rand = new Random(n); 
        
        // for k hash functions, generate random numbers within the range of our "bit" array (acts as hash function)
        for(int i=0; i<k; i++) {

            //generate index
            int index = rand.nextInt(size); 

            //set that "bit" to 1
            A[index] = 1; 
        }
    }
    
    /**
     * Lookup an element in the bloom filter.
     * @param n The element to look up.
     * @return Whether or not the specified element was found.
     */
    public boolean lookup(int n){

        //Random generator with the same seed will return same sequence of numbers
        Random rand = new Random(n); 
        
        for(int i=0; i<k; i++) {
            //Corresponds to the indices of the bit array that would be set if the element was inserted, based on number of hashes
            int index = rand.nextInt(size); 
            
            //If any of the bits are 0 the element was not added to the filter
            if(A[index]==0) { 
                //immediately return false
                return false;               
            }
        }
        return true;
    }
    
    /**
     * Returns the false positive rate of the bloom filter.
     * @param num Number of elements to query.
     * @return The false positive rate.
     */
    public double fpRate(int num){
        //False positives + true negatives
        int total_negatives = 0; 
        
        //false positives
        int fp = 0; 
        
        Random rand = new Random();
        
        for(int i=0; i<num; i++) {
            //Randomly generate ints that were not inserted
            int trial = insertion_range + rand.nextInt(insertion_range);
            
            if(!actual.contains(trial)) { 
                // If the trial element was not inserted, increment the total negatives
                total_negatives++;
                
                //If the filter says that the element is in the set then increment the number of false positives
                if(lookup(trial)) { 
                    fp++;
                }
            }
        }
        //False positive rate
        return (double)fp/(double)total_negatives; 
    }

    /**
     * Shows the correct usage for the program, and exits.
     */
    public static void showUsageAndExit() {
        System.out.println("Incorrect usage: ./BloomFilters <number of hash functions> <size of bit array>");
        System.exit(1);
    }
    
    /**
     * Runner for one iteration of the experiment.
     * @param args Arguments to be passed for experimentation.
     */
    public static void main(String[] args){
        //make sure we have all the arguments necessary
        if(args.length != 2) {
            showUsageAndExit();
        }

        int k = Integer.parseInt(args[0]); // Number of hash functions
        int size = Integer.parseInt(args[1]); // Size of the bit array
        
        BloomFilters filter = new BloomFilters(k, size);
        Random rand = new Random();
        
        for(int i=0; i<num_insertions; i++) {
            //generate a number to insert between 0 and insertion_range
            int x = rand.nextInt(insertion_range); 

            //Insert element
            filter.insert(x); 
        }
        System.out.println(filter.fpRate(1000));
    }
}







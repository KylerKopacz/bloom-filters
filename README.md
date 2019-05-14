To run the code: java BloomFilters NUM_HASH_FUNCTIONS BIT_ARRAY_SIZE

This will return the false positive rate of 100,000 lookups after 10,000 insertions have been made for a bloom filter with NUM_HASH_FUNCTIONS different hash functions and a bit array of length BIT_ARRAY_SIZE

BloomFilters():
-This constructor takes in the number of hash functions and the isze of the bit array this instance will use
-Fields include k, the bit array, the bit array size, and a hashset containing all of the insertions

insert(int n):
-Takes in an integer that represents the element being added to the bloom filter
-Uses the random sequence of numbers with the inserted int as a seed to hash array values to 1

lookup(int n):
-Takes in the element in question
-Uses that element as a random seed to generate the sequence of indices that should be set to one
-Returns true if all of the required bits are 1 and false if at least one of them is 0

fpRate(int num):
-num represents the number of lookups that are to be performed in the analysis
-This method checks elements that are not in the bloom filter and keeps track of the false positive rate by incrementing fp when a false positive occurs and total_negatives any time the element in question is not actually there
-This outputs a double that represents the false positive rate of this specific bloom filter

main(String args[]):
-Takes in k number of hash functions and size of the bit array
-generates 10,000 random integer insertions
-Prints the false positive rate for 100,000 lookups that are not actually in the bloom filter
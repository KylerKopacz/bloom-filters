#!/bin/bash

javac *.java

mkdir -p output

echo "Starting Bloom Filter Experimentation..."
echo "NOTE: The contents of the output is the false positive rates, given various parameters.
"

echo "Starting experimentation with 3 hash functions and varying sizes of bit sets..."

java BloomFilters 3 10000 >> output/output3hashes.txt
java BloomFilters 3 20000 >> output/output3hashes.txt
java BloomFilters 3 30000 >> output/output3hashes.txt
java BloomFilters 3 40000 >> output/output3hashes.txt
java BloomFilters 3 50000 >> output/output3hashes.txt
java BloomFilters 3 60000 >> output/output3hashes.txt
java BloomFilters 3 70000 >> output/output3hashes.txt
java BloomFilters 3 80000 >> output/output3hashes.txt
java BloomFilters 3 90000 >> output/output3hashes.txt
java BloomFilters 3 100000 >> output/output3hashes.txt

echo "Done! check the \"output\" directory for results.
"  

echo "Now starting experimentation with varying number of hash sizes, and varying sizes of bit sets..."

for ((i=1;i<=10;i++))
do

echo "Starting round $i..."

java BloomFilters $i 10000 >> output/output10000.txt
java BloomFilters $i 25000 >> output/output25000.txt
java BloomFilters $i 50000 >> output/output50000.txt
java BloomFilters $i 100000 >> output/output100000.txt
java BloomFilters $i 200000 >> output/output200000.txt

echo "Finished with round $i."

done

echo "Done! check the \"output\" directory for results."

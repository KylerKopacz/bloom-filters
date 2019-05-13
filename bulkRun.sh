#!/bin/bash

javac *.java

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

for ((i=1;i<=10;i++))
do

osascript -e 'display notification "Starting Round" with title "Bloom Filter Status"'

java BloomFilters $i 10000 >> output/output10000.txt
java BloomFilters $i 25000 >> output/output25000.txt
java BloomFilters $i 50000 >> output/output50000.txt
java BloomFilters $i 100000 >> output/output100000.txt
java BloomFilters $i 200000 >> output/output200000.txt

osascript -e 'display notification "Done with Round" with title "Bloom Filter Status"'
osascript -e 'say "Congratulations!"'
done
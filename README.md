# Bloom Filter Simulation
## By Dylan Finazzo, Kyler Kopacz, and Jack Fergus

An exploration of Bloom Filters and their effectiveness, written in Java (and a little bit of shell).

Assuming that you are using bash, run the code by typing:
```
./run.sh
```
This will run the experiment multiple times with our parameters. Outputs representing false positive rate for each iteration into the "./output/" directory. 

To run one iteration with your own arguments, type:
```
javac BloomFilters.java
java BloomFilters k m
```
where k is the amount of hash functions used in the filter, and m is the size of the bitset.

You can also find documentation for the code in the form of javadocs. To see the docs, open the "docs" folder in a file explorer, and open "index.html" in your browser. To see more of how each method is being implemented, you can check out the comments in the source code.

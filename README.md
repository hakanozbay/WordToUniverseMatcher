WordToUniverseMatcher
=====================

This project aims to build a universe of words, and given an input, will match the input against the universe. Matches will be collated and provided with a confidence level assigned to every match.

Building the Universe
=====================

A Universe interface is created to allow implementing classes to utilize any underlying data structure. This first implementation uses a Treemap, which is a form of a Binary Search Tree. The tree is only 2 levels deep from the root. The first level nodes are all integers representing the lengths of the words in the universe. The second level are the words whose length are of the integer value of its parent node. Therefore every word is categorized by its length and inserted into the tree accordingly.

Matching Input to the Universe
==============================

An input is matched to the universe by 3 ways:

1) Checking if the input is an anagram of words in the universe 

2) Checking if all the characters of the input exist in words in the universe and then find approximate matches

3) Find approximate matches of the input to words in the universe 

How these 3 methods are achieved:

1) An anagram of 2 words are both with the same length and the numeric product of its constituent characters are equal to one another.

2) The numeric product of the input's constituent characters must be a factor of the numeric product of words in the universe first. Only a subset of the universe is checked against to narrow down more realistic potential matches. the range of words checked against in the universe is input.length until input.length+2. Afterwards a transformation calculation on the input is made to generate the number of steps taken to transform the input to each potential match. This is called the "edit distance" and is expanded below.

3) The edit distance is calculated for the input against a subset of words in the universe in the range of input.length-1 to input.length+2. The edit distance algorithm used is the Levenshtein distance algorithm. An edit distance of less than 10 is considered a match.


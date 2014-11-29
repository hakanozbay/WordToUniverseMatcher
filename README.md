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
2) Checking if all the characters of the input exist in words in the universe 
3) Checking approximate matches of the input to words in the universe 

How these 3 methods are achieved:
1) An anagram of 2 words are both with the same length and the numeric product of its constituant characters are equal to one another.
2) 

Authors: Christina Choi and Milla Penelope Markovich

Help received: Office Hours

Main topics for this homework:
1. Recursive Functions
2. Sorting Algorithms
3. Trees
4. Sets and Lists

Rules: 
1. Write a Java interface called NeedlesslyRecursive with four static methods that implement recursive solutions to the following:
a) The function 𝑎, defined as follows, where (𝑥 and 𝑦 are BigIntegers):
𝑎(𝑥,𝑦)=⎧⎩⎨⎪⎪𝑦+1,𝑎(𝑥−1,1),𝑎(𝑥−1,𝑎(𝑥,𝑦−1)),𝑥=0∧𝑦≥0𝑥>0∧𝑦=0𝑥>0∧𝑦>0Throw an exception if 𝑥 or 𝑦 is null or less than zero.
b) A function that, when given an integer, returns the string containing the binary representation of the integer. For example, for 43, return "101011", and for -9 return "-1001".
c) A function that takes in an integer 𝑛 and returns the largest integer less than or equal to log3𝑛.
d) A function to compute 𝑥𝑛, where 𝑥 is a BigInteger and 𝑛 is an integer, using the famous algorithm that takes around log𝑛 steps, not 𝑛 steps.
Place a comment at the top of your file stating that you know these methods would not ordinarily be written recursively, but that you are writing them recursively for practice. Submit this interface in the file NeedlesslyRecursive.java. A unit test has been provided to you at the bottom of this assignment page.

2) The value of NeedlesslyRecursive.a(4, 2) has 19729 decimal digits, so running the recursive algorithm without memoization will never complete in the lifetime of our sun. But you can work out on paper (or a tablet or whiteboard) a concise expression for this exact value. Show it and its derivation. You may use the ↑ notation that appears on the course notes on Mathematics for Computer Science.

3) We saw this function in class:
𝐶(𝑛,𝑘)={1,𝐶(𝑛−1,𝑘−1)+𝐶(𝑛−1,𝑘),𝑘=0∨𝑘=𝑛0<𝑘<𝑛It turns out you can also define it like this:
𝐶(𝑛,𝑘)=𝑛!𝑘!(𝑛−𝑘)!Give the worst-case complexity of (a) the naïve recursive, (b) the non-recursive algorithms for computing 𝐶(𝑛,𝑘). You may assume all values can fit in a single machine word, so your complexity measure can be a function of both 𝑛 and 𝑘.

4)Draw detailed pictures of the progression of the following algorithms as they sort the array [81 9 17 21 20 8 2 5 1 83 23]. Give the same amount of detail as was given in the examples on the course notes on sorting. Work out your answers without the aid of a computer, using the computer only to check your work.
Selection Sort
Gnome Sort
Insertion Sort
Quick Sort (using first element as pivot)
Merge Sort
Heap Sort
Radix Sort
5) In your own words, but very, very, concisely, write a short one-sentence-fragment description for each of the following classifications of sorting algorithms: exchange, insertion, selection, merge, distribution, hybrid, concurrent, and impractical. Although brevity is important, make sure to capture the essence of each class.

6) Write a Java interface called Sets with two static methods: one to return all subsets of a given generic set, and the other to return a sorted list of all values that are multiples of a given base from a set of integers. Use the unit tests below to both better understand the requirements and to of course test your solution. Pay attention to the restrictions shown in the unit tests (noting the security concerns). Please use Java’s built-in set, list, and sort functionality.
For the following tree:
anotherexampletree.png
7) What is the size of this tree?
How many edges does this tree have?
What are the leaves?
What are the children of D?
What is the depth of G?
What is the degree of G?
What are the ancestors of G?
What are the descendants of G?
What are the nodes on level 3?
What is the height of the tree?
What is the width of the tree?
What is the height of the node D?
What is the simplest path from P to E?
What is the degree of the tree?
Enumerate the nodes in breadth-first order.
Enumerate the nodes in depth-first order.

8) Draw all 14 binary trees of size 4. Circle the ones that are complete trees.

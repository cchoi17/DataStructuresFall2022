#Homework 2

Authors: Christina Choi and Shawn Seah

Rules:
The rules to follow are:

In your new class, add a new method called capacity() which does the obvious thing.
Your structure should start off with an array of capacity of 16 elements.
If the array is full, and you are asked to add a new element, then double the storage before adding the element. In Java, you cannot actually expand an array, but you can create a new array whose capacity is double the current size and copy the elements over.
If the size of the structure goes below one-fourth of the capacity, then halve the capacity, but only if the capacity is larger than 16.

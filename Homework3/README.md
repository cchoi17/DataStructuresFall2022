Homework 3: Lists

Rules: For this assignment, you will not be building anything from scratch. Instead, you will start with the classes I built on my notes on Lists, namely the simple (doubly-) linked list and the simple (singly-linked) immutable list.

To the mutable, doubly-linked list implementation, add the following mutating methods. You MUST implement take, drop, and reverse, by manipulating links only. There is to be no creation of new nodes and no copying data between nodes. You may ONLY adjust links in existing nodes.

take(n): Keep only the first n elements of the list, removing the rest
drop(n): Remove the first n elements of this list
reverse(): Reverse this list
append(other): Append all the elements of the other list to the end of this list
map(f): Replace all items x in this list with f(x)
filter(p): Keep only the items in this list for which the predicate p holds
To the immutable, singly-linked list implementation, add the following methods:

take(n): Return a new list containing the first n elements of this list
drop(n): Return a new list containing all but the first n elements of this list
reversed(): Return a new list containing the elements of this list but in reverse order
append(other): Return a new list containing all the elements of this list followed by all the elements of the other list
map(f): Return a new list made from applying f to all items x in this list
filter(p): Return a new list made from only those elements in this list for which the predicate p holds
To both list implementations, add:

last(): Return the last element of this list
every(p): Return whether every item in this list satisfies predicate p
some(p): Return whether at least item in this list satisfies predicate p

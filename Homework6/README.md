Collaborators:  Christina Choi, Milla Penelope Markovic
TA Assistance:  Tanya Nobal, Jennifer Saio, and Nat

Homework Rules:
For this assignment, you will create a Java class called WordFinder whose functionality can be determined from the supplied unit test below. Essentially, a word finder represents a collection of non-empty, non-blank words, optimized for autocompletion. The methods are:

finder.add(word)
Add the given word, trimmed, to the collection, throwing an IllegalArgumentException if the word is blank.
finder.contains(word)
Return whether the given word (which you should trim first) is in the collection.
finder.allWords()
Return the sorted list of all of the added (and previously trimmed) words.
finder.suggestions(prefix)
Return a sorted list of all words in the collection having the given prefix (which you should trim first), but if the prefix is blank, throw an IllegalArgumentException.
There are, however, some important implementation restrictions that are not covered by the tests below, but that I will manually check when grading:

The class must implement a ternary search tree, as defined in class.
Adding, finding, generating suggestions, and enumerating must all proceed recursively.

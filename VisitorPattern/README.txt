Project Description::

File Processing Decorators 
Design a visitor, PopulateVisitor, that reads from an input file and stores it in a tree. You can decide what kind of tree to use. The visitor should return a reference to this tree. The element for this visitor is the name of the input file the TreeBuilder (or whatever class has all the methods needed to build a tree). All assumptions about the input file in assignment-4 are also applicable here. 
Design a visitor, PalindromeHighlight, that takes the tree as an element, created by the previous visitor, and updates the tree's content by modifying all the Palindrome words, greater than 3 characters, to be capitalized. Please note that except creating the tree, PopulateVisitor should NOT store any information in the tree to help this visitor. 
Design a visitor, PrimeLength, that takes the tree as an element, which was returned by the previous visitor, and updates the tree's content by modifying all the words whose length is a prime number, by adding a suffix "-PRIME" to the string. 
Design a visitor, PrintTree, that takes the tree as an element, which was returned by the previous visitor, and prints the tree's distinct words, in ascending (alphanumeric) order, in the output file. 
From the command line accept the input file name, output file name, and debug level. 
We will run your code using ANT in the following way. You should accept input.txt and output.txt as command line arguments. 
ant -buildfile src/build.xml run -Darg0=input.txt  -Darg1=output.txt Darg2=debugLevel

Your driver code should create the visitors, elements (if needed), and then the elements should accept the visitors. 
Design your own debug scheme, similar to what was used in the previous assignment. 
Assuming you are in the directory containing this README:

Running Directions::
## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=debuglevel

-----------------------------------------------------------------------

## To create tarball for submission
tarzip or tar -zcvf firstName_secondName_firstName_secondName_assign_number.tar.gz firstName_secondName_firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 11/21/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Linked List is used to build Binary search Tree. 

Complexities for each operations:
If n = Total number of nodes in BST then

Worst Case Complexity for operations
If created Binary tree is skewed to right or left
populate Visitor - O(n)
Palindrome Height- O(n)
prime length- O(n)
Print Tree = O(n)

Average Case Complexity for operations
populate Visitor - O(logn)
Palindrome Height- O(logn)
prime length- O(logn)
Print Tree = O(logn)

Best Case Complexity for operations
If there is only one word in input file
populate Visitor - O(1)
Palindrome Height- O(1)
prime length- O(1)
Print Tree = O(1)

//Design Principles
There are 2 classes included which does not implement any interface - Node.java and TreeBuilder.java
As Node.java is an entity class we do not implement it using interface and TreeBuilder.java is a utility class
which helps create and populate BST

//Debug levels
DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
DEBUG_VALUE=3 [Print to stdout everytime a palindrome is found with character count greater than 3]
DEBUG_VALUE=2 [Print to stdout everytime a word with prime length is found]
DEBUG_VALUE=1 [Print to stdout everytime result is written to output file]
DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is OK to write to the output file though" ]

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

Code for binary tree implementation is taken from studentCoursesBackup assignment.
https://bitbucket.org/sarangsawant/sarang_sawant_assign_2/src

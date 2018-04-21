Goal: Application of design principles for a simple multi-threaded application

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2= NUM_THREADS -Darg3= deletewords -Darg4=debuglevel

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

[Date: 07/11/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
The time complexities of all methods of wordTree

Integer array "stats" is used to save results of all 3 operations.
Linked List is used to build Binary search Tree. 

Complexities for each operations:
If n = Total number of nodes in BST then

Worst Case Complexity for operations
If created by Binary tree is skewed to right or left
Total words - O(n)
Total characters - O(n)
Total Distinct words - O(n)

Average Case Complexity for operations
Total words - O(logn)
Total characters - O(logn)
Total Distinct words - O(logn)

Best Case Complexity for operations
If there is only one word in input file
Total words - O(1)
Total characters - O(1)
Total Distinct words - O(1)
  
There are 2 classes included which does not implement any interface - Node.java and TreeBuilder.java
As Node.java is an entity class we do not implement it using interface and TreeBuilder.java is a utility class
which helps create and populate BST

DEBUG_VALUE=2 [Print to stdout everytime count for any word becomes zero]
DEBUG_VALUE=1 [Print to stdout everytime result is written to output file]

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

Code for binary tree implementation is taken from studentCoursesBackup assignment.
https://bitbucket.org/sarangsawant/sarang_sawant_assign_2/src

Project Description::
 
Backup System for Student Course Assignments
Create a class Node to store the B-Number (4 digit int) and an arraylist of course names (strings). The possible course names are "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K". 
Write code for a tree that has the features to insert, search, and delete Nodes. You need to write code for the tree by yourself. However, you are allowed to get help from a book or online source (for example the source code for BST, AVL, 2-3, 2-3-4, etc.) If you do so, cite the URL of where you got the code from both in your source code and also README.txt. It will be considered CHEATING if you do not cite the source of any code on tree that you use/adapt. 
As you need to modify the code to implement the Observer pattern, you can't just use an in-built tree in Java. Each Node of the tree should implement both the Subject and the Observer interface. 
Do not use the built-in Observer classes/interfaces in Java. 
Populate the tree using the data from an input file, input.txt, that has the following format: 
1234:C
2345:D
1234:A
1234:D
1234:E
2345:F
3425:C
...

The inputs may not be unique (some entries may repeat). So, either ignore the repeated inputs manually (if you use an ArrayList, for example), or use a key-value data structure that ensures unique entries. 
Assume that the input.txt and delete.txt will be well formatted. 
Your tree builder should be such that when you create a node (node_orig as the variable name), you should clone (using the prototype pattern) it twice to get two Nodes (let's say backup_Node_1 and backup_Node_2 as the variables holding the references). Setup backup_Node_1 and backup_Node_2 as observers of node_orig. node_orig, backup_Node_1, and backup_Node_2, should be instances of the same Node class. As node_orig is the subject, you should store the references of backup_Node_1 and backup_Node_2 in a data structure for listeners in Node_orig (array list of references, for example). 
Apply the following delete operations, processing line at a time, from the file delete.txt. The file has the following format: 
1234:C
2345:D
1234:A
...
Search for the node with the B_Number in the line, and then delete the corresponding course in that Node. If that course does not exist to delete, then ignore and move to the next line.
I the nodes does not exist with that BNumber, then ignore and move to the next line. Once the changes to the node_orig are done, the changes should be updated to both the corresponding nodes (call notifyAll(...)). Note that the updates for a line in delete.txt should be sent, before the next line is processed. 
From the command line accept the following args: input.txt, delete.txt, output1.txt, output2.txt, output3.txt. 
Add a method to your tree, printNodes(Results r, ...), that stores in Results the list of courses for each student, sorted by the B_Number. 

Running Directions::
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg3=FOURTH -Darg4=FIFTH

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf sarang_sawant_assign_2.tar.gz sarang_sawant_assign_2

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/02/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)


Tree implemented in this project is Binary Search Tree(BST) because average running time of BST is O(log n) where n is Total no. of nodes in BST. 
ArrayList<String> is used for storing courses for each BNumber.

If n = Total number of nodes in BST then
Worst case running Time complexity for seaching a node in BST is O(n).
Worst case running Time for inserting a node in BST is O(n).
Worst case running Time for deleting a course from a node in BST is O(n).

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code

Reference for searching, inserting a node in BST is taken from
http://www.sanfoundry.com/java-program-implement-binary-search-tree/


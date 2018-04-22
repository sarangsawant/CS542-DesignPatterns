Project Description::
Develop a program,to design a new data structure. Design a data structure named "MyArrayList" with the following properties: 
-The data structure has an integer array as a private data member. Start with some initial int array size, say 50. If the input size is greater than 50, then create a new array of size 75, copy the contents of the original array into this new array, and then continue). 

-void insertSorted(int newValue); This method should insert a new value but keep the data structure sorted in ascending order. If a value is a duplicate, you can store it before or after an existing value. 

-void removeValue(int value); This method should remove all occurences of a value, if it exists, and then move the remaining values so that the array list has all values in ascending order. You can return an error code from this method (change return from void to int) if it helps your design. 

-int indexOf(int value); This method should return the index of the first occurrence a value. It should return -1 if the value does not exist in the array list. 

-int size(); This method should return the total number of values that are stored in the array list. 

-int sum(); This method should return the sum of all values that are stored in the array list. 


Running the project::
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=/home/input_file/input_file.txt -Darg1=/home/output_file/output_file.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf sarang_sawant_assign_1.tar.gz sarang_sawant_assign_1

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 15th Sep 2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Integer array for storing numbers from input.txt file. 
If n = total count of numbers in input.txt 

#Time complexity for insertSorted()
O(n + nlogn) - Fisrt to insert element in array and then to sort 

#Time complexity for removeValue()
O(n)

#Time complexity for indexOf()
O(n)

#Time complexity for size()
O(n)

#Time complexity for sum()
O(n)

#Space complexity to populate array by input file values
O(n) + O(n)

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).


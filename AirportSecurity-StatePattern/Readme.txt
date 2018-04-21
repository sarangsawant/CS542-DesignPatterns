Project Description::
 
Let’s call the factors, that affect the security implementation of an airport, SecurityFactors. Let’s call the operation of tightening/loosening security, tightenOrLoosenSecurity(). The following are the states that an airport can be in, 
LOW_RISK
MODERATE_RISK
HIGH_RISK
Two metrics are used to determine the state of the airport. The 2 metrics are, 
Average Traffic Per Day
Computed as ⇒ Total number of travellers ÷ Total number of days 
Average Prohibited Items Per Day
Computed as ⇒ Total number of prohibited items ÷ Total number of days 
The following are the list of prohibited items, 
Gun
NailCutter
Blade
Knife
For each state that the airport can be in, the following are the conditions that need to be satisfied, 
LOW_RISK
0 ≤ average traffic per day < 4 OR
0 ≤ average prohibited items per day < 1
MODERATE_RISK
4 ≤ average traffic per day < 8 OR
1 ≤ average prohibited items per day < 2
HIGH_RISK
average traffic per day ≥ 8 OR
average prohibited items per day ≥ 2

If conditions for 2 states get satisfied, then the state with the higher risk is chosen. 
Let's assume that there are 10 operations that can be performed by the security agency, based on the current state of the aiport. Each operation is identified by an ID. Thus, we have 10 IDs in the range [1, 10]. For each state of the airport, the security performs a subset of the operations. These are mentioned below, 
LOW_RISK
OperationID = 1
OperationID = 3
OperationID = 5
OperationID = 7
OperationID = 9
MODERATE_RISK
OperationID = 2
OperationID = 3
OperationID = 5
OperationID = 8
OperationID = 9
HIGH_RISK
OperationID = 2
OperationID = 4
OperationID = 6
OperationID = 8
OperationID = 10
For every traveller that enters the airport, the program should output the subset of operations that need to be performed in order to maintain peace and harmony. 
Assuming you are in the directory containing this README:

Running Directions::
## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf sarang_sawant_assign_3.tar.gz sarang_sawant_assign_3

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/19/2017]

--------------------------------------------------------------------------
Output File
Entries in output file is based on assumption that current state is updated after computing 
average travelers per day and average prohibited items per day, and then operations are performed.

total days is calculated as 
if input file contains following entries
Day:1;TOD:10:00;Airline:United;Item:ShavingBrush
Day:2;TOD:13:00;Airline:CapeAir;Item:Knife
Day:4;TOD:11:30;Airline:JetBlue;Item:NailCutter

Here while reading 3rd record, total days(for computing averages) is 4

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

ArrayList<String> is used to save the operations which are then written to output file.

Running time complexity for computing the exact State change is O(1)

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code



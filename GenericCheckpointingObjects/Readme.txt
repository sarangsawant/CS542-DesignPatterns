Project Description:: 
Checkpointing Objects 
The purpose of this assignment is to create a generic library to serialize and deserialize objects. The code should allow the conversion of objects into a wire format. The code should be designed using dynamic proxies and reflection so that addition of new objects or serialization formats causes minimal changes (reduces the ripple effect). 


-The driver code should invoke methods on the dynamic proxy, as if it is invoking methods on an object that implements the 2 interfaces (StoreI and RestoreI). Remember to cast the -Dynamic proxy to the correct interface before invoking the method. 
-Each invocation will transfer control to the invoke method of the invocation handler. 
-Invoke a method on the invocation handler to set a file name for the checkpoint file. Alternatively, you can add a parameter to the readObj and writeObj methods to include the file name. 
-The invocation handler should have a method to open a file and a method to close the file. 

Flow of Control:: 
create a Dynamic Proxy 
create a vector of SerializableObject. Populate it with instances of MyAllTypesFirst and MyAllTypesSecond 
when you create instances of MyAllTypesFirst and MyAllTypesSecond (using randomly generated values), if the value of an int, double, or long is less than 10, then that field should NOT be serialized. As shown in MyAllTypes2.txt, some fields could be missing from the serialized output. 
call writeObj for each instance of the vector so that the checkPoint file is created via the proxy implementation. 
call readObj to read the checkpoint file objects and create a vector with the return instances. 
compare the serialized and deserialized vectors and report how many instances match. 

Running Directions::
"This assignment's submission is my own work and I did not discuss with any other past or current student, nor did I have access to a previous submission of this assignment by another student."
 
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
tarzip or tar -zcvf firstName_secondName_firstName_secondName_assign_6.tar.gz firstName_secondName_firstName_secondName_assign_6
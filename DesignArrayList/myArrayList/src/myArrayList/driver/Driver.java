package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver {
	public static void main(String[] args) {

		if(args.length == 2) {
			String INPUT_FILENAME = args[0];
			String OUTPUT_FILENAME = args[1];

			FileProcessor fileProcessor = new FileProcessor();
			MyArrayList myArrayList = new MyArrayList();
			Results results = new Results();
			MyArrayListTest myArrayListTest = new MyArrayListTest();
			
			fileProcessor.openFile(INPUT_FILENAME);
	
			String line = "";
			while (line != null) {
				line = fileProcessor.readLine();
				if(line != null){
					try{
						myArrayList.insertSorted(Integer.parseInt(line));
					}catch (NumberFormatException e) {
						
					}
				}
			}
			
			String sum = "The sum of all the values in the array list is: ";
			sum = sum + myArrayList.sum() + "\n";
			results.storeNewResult(sum);
			
			myArrayListTest.testMe(myArrayList, results);

			results.writeToFile(OUTPUT_FILENAME);
		}else
			System.out.println("Incorrect number of arguments");
	}
}

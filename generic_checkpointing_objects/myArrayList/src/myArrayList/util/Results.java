package myArrayList.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Results  implements FileDisplayInterface, StdoutDisplayInterface{

	ArrayList<String> list = new ArrayList<>();
	String result = "";
	
	/**
	 * 	This method is used to write the output to file of the implemented functions
	 * @param s
	 */
	public void writeToFile(String fileName) {
		 FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(fileName);
			for(String str : list){
				byte[] strToBytes = str.getBytes();
				outputStream.write(strToBytes);
			}
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Output file cannot be opened!!");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Exception while writing bytes to file.");
			System.exit(1);
		}
		 
	}
	
	/**
	 * 
	 * @param s
	 */
	public void writeToStdout(String s) {
		
	}
	
	/**
	 * This method adds the result in arraylist
	 * @param result
	 */
	public void storeNewResult(String result){
		list.add(result);
	}
	
	/**
	 * This method returns a template for each test function result
	 * @param name
	 * @param Status
	 * @param message
	 * @return
	 */
	public String generateResultFormat(String name, String Status, String message){
		result = "\nTest Name: " + name;
		
		if(Status.equals("Passed"))
			result = result + "\nStatus   : Test '" + name + "' "+ Status +"\n";
		else{
			result = result + "\nStatus   : Test '" + name + "' "+ Status;
			result = result + "\nError    : " + message + "\n";
		}
		
		return result;
	}
}

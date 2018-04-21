package myArrayList.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;
	
	public void openFile(String FileName) {
		try {
			fileReader = new FileReader(FileName);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("File not found at location: " + FileName);
			System.exit(1);
		}
	}
	/**
	 * This method returns one line at a time reading from a input file
	 * @return
	 */
	public String readLine() {
		String line = null;
		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println("Error while reading line from input file");
			System.exit(1);
		}
		return line;
	}
}

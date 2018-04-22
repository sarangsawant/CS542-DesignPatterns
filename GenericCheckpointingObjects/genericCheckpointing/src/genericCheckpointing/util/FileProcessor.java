package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;
	BufferedWriter bw = null;;
	FileWriter fw = null;
	
	public void openFile(String FileName) {
		try {
			fileReader = new FileReader(FileName);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("File not found at location: " + FileName);
			System.exit(1);
		} 
	}
	
	public void openFileForWrite(String FileName) {
		try {
			fw = new FileWriter(FileName);
			bw = new BufferedWriter(fw);
		} catch (FileNotFoundException e) {
			System.out.println("File not found at location: " + FileName);
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void writeFile(String str) {
		try {
			bw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeFile() {
		try {
			if(bufferedReader!=null)
				bufferedReader.close();
			
			if(fileReader!=null)
				fileReader.close();
			
			if(bw !=null)
				bw.close();
			
			if(fw!=null)
				fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

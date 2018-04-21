package airportSecurityState.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Results  implements FileDisplayInterface{

	List<String> list = new ArrayList<>();
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	/**
	 * 	This method is used to write the output to file of the implemented functions
	 * @param s
	 */
	public void writeToFile(String fileName) {
		 FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(fileName);
			for(String str : list){
				str = str + "\n";
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
	
	public void addOperationToResult(String str) {
		if(str != null) {
			list.add(str);
		}
	}
	
}

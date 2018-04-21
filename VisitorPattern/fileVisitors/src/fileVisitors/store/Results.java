package fileVisitors.store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fileVisitors.util.FileDisplayInterface;
import fileVisitors.util.StdoutDisplayInterface;
import fileVisitors.util.MyLogger;


public class Results implements FileDisplayInterface, StdoutDisplayInterface{

	private String filename;
	private File file;
	private BufferedWriter bufferedWriter;
	private ArrayList<String> arrayList;
	
	/**
	 * Empty Results constructor which initializes all of its private data members
	 * which also generates the file if does not exist with default file name
	 */
	public Results() {
		// TODO Auto-generated constructor stub
		filename = "output.txt";
		arrayList = new ArrayList<String>();
		try {
			String filepath = filename;
			file = new File(filepath);
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		MyLogger.writeMessage("Results Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Results constructor which takes following parameters and assigns it to
	 * filename and also initializes all other of its private data members
	 * which also generates the file if does not exist with file name passed to it
	 * @param resultsIn
	 */
	public Results(String resultsIn) {
		// TODO Auto-generated constructor stub
		filename = resultsIn;
		arrayList = new ArrayList<String>();
		try {
			String filepath = filename;
			file = new File(filepath);
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.close();
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.err.println("FileNotFoundException caught for file " + "\n" + e.getMessage());
			System.exit(1);
		}catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			System.exit(1);
		}
		MyLogger.writeMessage("Results Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * This method stores all the results in an array
	 * @param outputIn
	 */
	public void storeNewResult(String outputIn){
		arrayList.add(outputIn);
	}


	@Override
	public void writeSchedulesToFile(String s) {
		// TODO Auto-generated method stub
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.write(s);
			bufferedWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error while writimg results to : " + filename);
			System.err.println(e.getMessage());
			System.exit(1);
		}
		MyLogger.writeMessage("Results are written to file", MyLogger.DebugLevel.FROM_RESULTS);
	}
	
	@Override
	public void writeSchedulesToFile() {
		// TODO Auto-generated method stub
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			for (String string : arrayList) {
				bufferedWriter.write(string);
			}
			bufferedWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error while writimg results to : " + filename);
			System.err.println(e.getMessage());
			System.exit(1);
		}
		MyLogger.writeMessage("Results are written to the output file", MyLogger.DebugLevel.FROM_RESULTS);
	}
	
	@Override
	public void writeToScreen(String s) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void writeToScreen() {
		// TODO Auto-generated method stub
		
	}

}

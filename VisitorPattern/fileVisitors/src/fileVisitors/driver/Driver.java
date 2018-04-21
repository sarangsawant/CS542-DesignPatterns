package fileVisitors.driver;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.store.Results;
import fileVisitors.util.TreeBuilder;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;;

/**
 * 
 * @author Kiran Kadam<kkadam1@binghamton.edu> and Sarang Sawant<ssawant5@binghamton.edu>
 * @version 1.0
 * @since 2017-11-16
 *
 */

public class Driver {

	/**
	 * @param args main method takes three command line arguments
	 */
	public static void main(String[] args) {
		
		int debugLevel=0;
		/**
		 * This check validates the arguments
		 */
		if (args.length!=3) {
			String errmsg = "usage: java %s <input_file> <output_file> <debug_value>";
			System.err.format(errmsg + "\n", Driver.class.getName());
			System.exit(1);
		}
		
		/**
		 * Validates id debug level is integer or not
		 */
		if(!IsInteger(args[2])){
			System.err.format("Invalid Debug value\n", Driver.class.getName());
			System.exit(1);
		}
		
		debugLevel=Integer.parseInt(args[2]);
		/**
		 * Validates the debug level is in range or not
		 */
		if(debugLevel < 0 || debugLevel > 4){
			System.err.format("Debug value is not in range\n", Driver.class.getName());
			System.exit(1);
		}
		
		MyLogger.setDebugValue(debugLevel);
		
		FileProcessor fileProcessor = null;
		String readLine = null;
		
		/**
		 * checking if input file is empty
		 */
		fileProcessor = new FileProcessor(args[0]);
		fileCheck(readLine, fileProcessor, args[0]);
		
		fileProcessor = new FileProcessor(args[0]);
		Results results = new Results(args[1]);
		TreeBuilder builder = TreeBuilder.getInstance();
		PopulateVisitor populateVisitor = new PopulateVisitor(fileProcessor);
		PalindromeHighlight palindromeHighlight = new PalindromeHighlight();
		PrimeLength primeLength = new PrimeLength();
		PrintTree printTree = new PrintTree(results);
		
		builder.accept(populateVisitor);
		builder.accept(palindromeHighlight);
		builder.accept(primeLength);
		builder.accept(printTree);
		
	}
	
	/**
	 * IsInteger takes one string parameter and returns boolean true if it is integer else returns false
	 * @param string
	 * @return
	 */
	private static boolean IsInteger(String string) {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * takes following parameters and check if input file is empty if yes exits the 
	 * programs with proper error message
	 * @param readLine
	 * @param fileProcessor
	 * @param args
	 */
	private static void fileCheck(String readLine, FileProcessor fileProcessor, String args) {
		// TODO Auto-generated method stub
		while ((readLine = fileProcessor.readLine()) == null) {
			System.err.println("File " + args + " is empty");
			System.exit(1);
		}
	}
}

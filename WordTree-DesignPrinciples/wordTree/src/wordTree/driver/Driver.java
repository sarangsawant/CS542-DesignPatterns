package wordTree.driver;

import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import wordTree.util.TreeBuilder;

/**
 * 
 * @author Kiran Kadam<kkadam1@binghamton.edu> and Sarang Sawant<ssawant5@binghamton.edu>
 * @version 1.0
 * @since 2017-10-27
 *
 */

public class Driver {
	
	/**
	 * @param args main method takes five command line arguments
	 */
	public static void main(String [] args){
		
		int threads=0, debugLevel=0;
		/**
		 * This check validates the arguments
		 */
		if (args.length!=5) {
			String errmsg = "usage: java %s <input_file> <output_file> <NUM_THREADS> <delete words> <debug_value>";
			System.err.format(errmsg + "\n", Driver.class.getName());
			System.exit(1);
		}
		
		/**
		 * Validates id NUM_THREADS is integer or not
		 */
		if(!IsInteger(args[2])){
			System.err.format("Invalid number of threads\n", Driver.class.getName());
			System.exit(1);
		}
		
		threads = Integer.parseInt(args[2]);
		/**
		 * Validates id NUM_THREADS is integer or not
		 */
		if (threads < 1 || threads > 3) {
			System.err.format("Invalid number of threads\n", Driver.class.getName());
			System.exit(1);
		}
		
		/**
		 * Validates number of delete words
		 */
		if(args[3].split(" ").length!=threads){
			System.err.format("Invalid number of delete words\n", Driver.class.getName());
			System.exit(1);
		}
		
		
		/**
		 * Validates id debug level is integer or not
		 */
		if(!IsInteger(args[4])){
			System.err.format("Invalid Debug value\n", Driver.class.getName());
			System.exit(1);
		}
		
		debugLevel=Integer.parseInt(args[4]);
		MyLogger.setDebugValue(debugLevel);
		
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
		
		CreateWorkers createWorkers = new CreateWorkers(fileProcessor, results, builder);
		
		createWorkers.startPopulateWorkers(threads);
		
		createWorkers.startDeleteWorkers(threads, args[3]);
		
		results.storeNewResult(builder.getStats());
		results.writeSchedulesToFile();	
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

package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import wordTree.util.Node;
import wordTree.util.TreeBuilder;

public class PopulateThread implements Runnable{

	private FileProcessor fileProcessor;
	private Results results;
	private volatile TreeBuilder builder;
	
	/**
	 * Populate thread constructor
	 * @param fileProcessorIn
	 * @param resultsIn
	 * @param builderIn
	 */
	public PopulateThread(FileProcessor fileProcessorIn, Results resultsIn, TreeBuilder builderIn) {
		// TODO Auto-generated constructor stub
		fileProcessor = fileProcessorIn;
		setResults(resultsIn);
		setBuilder(builderIn);
		MyLogger.writeMessage("PopulateThread Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * 
	 * @return
	 */
	public synchronized TreeBuilder getBuilder() {
		return builder;
	}

	/**
	 * 
	 * @param builderIn
	 */
	public synchronized void setBuilder(TreeBuilder builderIn) {
		builder = builderIn;
	}


	/**
	 * @return the results
	 */
	public synchronized Results getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public synchronized void setResults(Results resultsIn) {
		results = resultsIn;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		String readLine = "";
		while((readLine = fileProcessor.readLine())!=null){
			String[] words = readLine.split("\\s+");
			for (String string: words){
				if (string.length()>0) {
					synchronized (TreeBuilder.lock) {
						if(!builder.searchWord(string)){
							Node node = builder.createNode(string);
							builder.insertNodesInBST(node);
						}else{
							builder.updateNode(string, true);
						}
					}
				}
			}
		}
		MyLogger.writeMessage("run method called of thread: " + Thread.class.getName()
				+ "while populating the tree", MyLogger.DebugLevel.IN_RUN);
	}

}

package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.MyLogger;
import wordTree.util.TreeBuilder;

public class DeleteThread implements Runnable{
	private String deleteWord;
	private Results results;
	private volatile TreeBuilder builder;
	
	public DeleteThread(String deleteWordIn, Results resultsIn, TreeBuilder builderIn) {
		// TODO Auto-generated constructor stub
		setDeleteWord(deleteWordIn);
		setResults(resultsIn);
		setBuilder(builderIn);
		MyLogger.writeMessage("DeleteThread Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * @return the deleWords
	 */
	public String getDeleteWord() {
		return deleteWord;
	}

	/**
	 * @param deleWords the deleWords to set
	 */
	public void setDeleteWord(String deleteWordIn) {
		deleteWord = deleteWordIn;
	}

	/**
	 * @return the builder
	 */
	public TreeBuilder getBuilder() {
		return builder;
	}

	/**
	 * @param builder the builder to set
	 */
	public void setBuilder(TreeBuilder builderIn) {
		builder = builderIn;
	}

	/**
	 * @return the results
	 */
	public Results getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(Results resultsIn) {
		results = resultsIn;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (TreeBuilder.lock) {
			if (builder.searchWord(deleteWord)) {
				builder.updateNode(deleteWord, false);
			}
		}
		MyLogger.writeMessage("run method called of thread: " + Thread.class.getName()
				+ "while deleting the word", MyLogger.DebugLevel.IN_RUN);
	}

}

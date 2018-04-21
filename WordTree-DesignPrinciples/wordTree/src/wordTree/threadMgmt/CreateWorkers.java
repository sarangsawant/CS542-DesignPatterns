package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import wordTree.util.TreeBuilder;

public class CreateWorkers {

	private FileProcessor fileProcessor;
	private Results results;
	private Thread[] threadArray;
	private volatile TreeBuilder builder;
	
	public CreateWorkers(FileProcessor fileProcessorIn, Results resultIn, TreeBuilder builderIn) {
		fileProcessor = fileProcessorIn;
		setResults(resultIn);
		setBuilder(builderIn);
		MyLogger.writeMessage("CreateWorker Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
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
	public void setResults(Results results) {
		this.results = results;
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

	public synchronized void startPopulateWorkers(int threadCount) {
		threadArray = new Thread[threadCount];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(new PopulateThread(fileProcessor, results, builder));
			threadArray[i].start();
		}
		
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void startDeleteWorkers(int threadCount, String deleteWordsIn) {
		threadArray = new Thread[threadCount];
		String [] deleteWordsArray = deleteWordsIn.split(" ");
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(new DeleteThread(deleteWordsArray[i], results, builder));
			threadArray[i].start();
		}
		
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}

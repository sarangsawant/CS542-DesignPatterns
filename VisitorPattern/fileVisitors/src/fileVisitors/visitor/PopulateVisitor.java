package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.util.TreeBuilder;
import fileVisitors.util.Node;

public class PopulateVisitor implements VisitorI{

	private FileProcessor fileProcessor;
	public PopulateVisitor(FileProcessor fileProcessorIn) {
		// TODO Auto-generated constructor stub
		setFileProcessor(fileProcessorIn);
		MyLogger.writeMessage("PopulateVisitor Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);

	}

	/**
	 * @return the fileProcessor
	 */
	public FileProcessor getFileProcessor() {
		return fileProcessor;
	}

	/**
	 * @param fileProcessor the fileProcessor to set
	 */
	public void setFileProcessor(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	@Override
	public void visit(TreeBuilder builder) {
		// TODO Auto-generated method stub
		String readLine = "";
		while((readLine = fileProcessor.readLine())!=null){
			String[] words = readLine.split("\\s+");
			for (String string: words){
				if (string.length()>0) {
					if(!builder.searchWord(string)){
						Node node = builder.createNode(string);
						builder.insertNodesInBST(node);
					}
				}
			}
		}
	}
	
}

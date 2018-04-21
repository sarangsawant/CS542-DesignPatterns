package fileVisitors.visitor;

import java.util.ArrayList;
import java.util.Collections;

import fileVisitors.store.Results;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Node;
import fileVisitors.util.TreeBuilder;

public class PrintTree implements VisitorI{

	private ArrayList<String> arrayList = new ArrayList<String>();
	private Results results;
	public PrintTree(Results resultsIn) {
		// TODO Auto-generated constructor stub
		results = resultsIn;
		MyLogger.writeMessage("PrintTree Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);

	}

	@Override
	public void visit(TreeBuilder builder) {
		// TODO Auto-generated method stub
		traverseBSTTree(builder.getRoot());
		Collections.sort(arrayList);
		for (String string : arrayList) {
			results.storeNewResult(string + "\n");
		}
		results.writeSchedulesToFile();
	}
	
	private void traverseBSTTree(Node rootNode) {
    	inorderTraverseBST(rootNode);
    }
    
    /**
     * Function to inorder traverse a tree and add every node word to an arraylist
     * @param rootNode
     * @param statsIn
     */
    private void inorderTraverseBST(Node rootNode)  {
    	if(rootNode != null) {
    		arrayList.add(rootNode.getWord());
			inorderTraverseBST(rootNode.left);
			inorderTraverseBST(rootNode.right);
		}
	}

}

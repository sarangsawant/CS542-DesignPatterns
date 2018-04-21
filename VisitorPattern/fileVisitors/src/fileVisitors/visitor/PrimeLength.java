package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.Node;
import fileVisitors.util.TreeBuilder;

public class PrimeLength implements VisitorI{

	public PrimeLength() {
		MyLogger.writeMessage("PrimeLength Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	@Override
	public void visit(TreeBuilder builder) {
		// TODO Auto-generated method stub
		traverseBSTTree(builder.getRoot());
	}
	
	private void traverseBSTTree(Node rootNode) {
    	inorderTraverseBST(rootNode);
    }
    
    /**
     * Function to inorder traverse a tree and append keyword -PRIME if a word is of prime length
     * @param rootNode
     * @param statsIn
     */
    private void inorderTraverseBST(Node rootNode)  {
    	if(rootNode != null) {
    		if (checkForPrimeWordLength(rootNode.getWord().length())) {
    			MyLogger.writeMessage("The String " + rootNode.getWord() + " is of prime length", MyLogger.DebugLevel.PRIME);
				rootNode.setWord(rootNode.getWord() + "-PRIME");
			}
			inorderTraverseBST(rootNode.left);
			inorderTraverseBST(rootNode.right);
		}
	}

	private boolean checkForPrimeWordLength(int length) {
		// TODO Auto-generated method stub
		if (length==1) {
			return false;
		}else if(length==2 || length==3){
			return true;
		}
		
		int sqrRoot = getSqrRoot(length);
		for (int i = 2; i <= sqrRoot; i++) {
			if (length % i==0) {
				return false;
			}
		}
		return true;
	}

	private int getSqrRoot(int length) {
		// TODO Auto-generated method stub
		int i=1, results=1;
		while (results<length) {
			i++;
			results = i*i;
		}
		return i;
	}
	
}

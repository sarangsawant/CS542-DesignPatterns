package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.Node;
import fileVisitors.util.TreeBuilder;

public class PalindromeHighlight implements VisitorI{

	public PalindromeHighlight() {
		MyLogger.writeMessage("PalindromeHighlight Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);

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
     * Function to inorder traverse a tree and change palindrome word with character count greater than 3 to uppercase 
     * @param rootNode
     * @param statsIn
     */
    private void inorderTraverseBST(Node rootNode)  {
    	if(rootNode != null) {
    		if (rootNode.getWordLength() > 3 && checkPalindrome(rootNode.getWord().toLowerCase())) {
    			MyLogger.writeMessage("The String " + rootNode.getWord() +  " is a Palindrome", MyLogger.DebugLevel.PALINDROME);
				rootNode.setWord(rootNode.getWord().toUpperCase());
			}
			inorderTraverseBST(rootNode.left);
			inorderTraverseBST(rootNode.right);
		}
	}

    /**
     * This method checks if the input string is a palindrome or not.
     * @param word
     * @return
     */
	private boolean checkPalindrome(String word) {
		// TODO Auto-generated method stub
		char[] charArray = word.toCharArray();
		int i1=0,i2=charArray.length-1;
		while(i2>i1){
			if (charArray[i1]!=charArray[i2]) {
				return false;
			}
			i2--;
			i1++;
		}
		return true;
	}

}

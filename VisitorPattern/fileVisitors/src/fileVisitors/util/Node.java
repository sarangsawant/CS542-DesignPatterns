package fileVisitors.util;

public class Node{

	private String word;
	public Node left,right;
	private int wordLength; 
	
	
	public Node() {
		word = null;
		left = null;
		right = null;
		setWordLength(0);
		MyLogger.writeMessage("Node Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the wordLength
	 */
	public int getWordLength() {
		return wordLength;
	}

	/**
	 * @param wordLength the wordLength to set
	 */
	public void setWordLength(int wordLengthIn) {
		wordLength = wordLengthIn;
	}
	
}

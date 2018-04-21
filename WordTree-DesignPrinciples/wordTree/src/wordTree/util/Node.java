package wordTree.util;

public class Node{

	private String word;
	private volatile int wordCount;
	private volatile int characterCnt;
	public volatile Node left,right;
	
	
	public Node() {
		left = null;
		right = null;
		characterCnt = 0;
		wordCount = 0;
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

	public int getCharacterCnt() {
		return characterCnt;
	}

	public void setCharacterCnt(int characterCnt) {
		this.characterCnt = characterCnt;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	
}

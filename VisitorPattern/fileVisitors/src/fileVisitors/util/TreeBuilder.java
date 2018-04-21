package fileVisitors.util;

import fileVisitors.visitor.VisitorI;

public class TreeBuilder {

	private Node root;
	private static TreeBuilder treeBuilder;
	
	/**
	 * Private Constructor
	 */
	private TreeBuilder() {
		root = null;
		MyLogger.writeMessage("TreeBuilder Object instantiated", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public static TreeBuilder getInstance(){
		if(treeBuilder==null){
			synchronized (TreeBuilder.class) {
				if (treeBuilder==null) {
					treeBuilder = new TreeBuilder();
				}
			}
		}
		return treeBuilder;
	} 
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node rootIn) {
		root = rootIn;
	}
	
	
	/**
	 * This function is used to create new Node object by initializing its field according to input string
	 * @param str
	 * @return
	 */
	public Node createNode(String stringIn) {
		Node node = new Node();
		node.setWord(stringIn);
		node.setWordLength(stringIn.length());
		return node;
	}
	
	/**
	 * Inserts node in BST
	 * @param node
	 */
    public void insertNodesInBST(Node node) {
    	root = insertNodeToBST(root, node);
    }
    
    /**
     * Helper function
     * Lexographically compares 2 strings, and inserts the node accordingly into BST
     * @param rootNode
     * @param node
     * @return
     */
	private Node insertNodeToBST(Node rootNode, Node node) {
		if(rootNode == null) {
			rootNode = node;
			return rootNode;
		}
        if (rootNode.getWord().compareTo(node.getWord()) > 0){
        	rootNode.left = insertNodeToBST(rootNode.left, node);
        }else if (rootNode.getWord().compareTo(node.getWord()) < 0){
        	rootNode.right = insertNodeToBST(rootNode.right, node);
        }
        return rootNode;
	}
	
	/**
	 * This function is used to search word in BST
	 * @param str
	 * @return
	 */
	public boolean searchWord(String str) {
		return search(root, str);
    }
 
    /**
     * This function is used to check a word in BST
     * @param rootNode
     * @param word
     * @return
     */
    private boolean search(Node rootNode, String word){
        boolean found = false;
        while((rootNode != null) && !found) {
            String rootWord = rootNode.getWord();
            if (rootWord.compareTo(word) > 0){
            	rootNode = rootNode.left;
            }else if(rootWord.compareTo(word) < 0){
            	rootNode = rootNode.right;
            }else if(rootWord.compareTo(word) == 0){
                found = true;
                break;
            }
            found = search(rootNode, word);
        }
        return found;
    }
    
    /**
     * Accept method
     */
    public void accept(VisitorI visitorI) {
		visitorI.visit(this);
	}
    
    @Override
    public String toString() {
    	return root.getWord();
    }
}

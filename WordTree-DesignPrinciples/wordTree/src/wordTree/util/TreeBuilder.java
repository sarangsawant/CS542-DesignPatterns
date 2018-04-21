package wordTree.util;

public class TreeBuilder {

	private volatile Node root;
	private volatile int stats[];
	private volatile static TreeBuilder treeBuilder;
	public static final Object lock = new Object();
	/**
	 * Private Constructor
	 */
	private TreeBuilder() {
		root = null;
		stats= new int[]{0,0,0};
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
		node.setWordCount(1);
		node.setWord(stringIn);
		stats[0]=stats[0]+1;
		node.setCharacterCnt(stringIn.length());
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
     * If input string is present in BST, it increments word count of that particular node 
     * @param word
     * @return
     */
    public boolean updateNode(String word, boolean flag) {
    	boolean found = false;
    	Node rootNode = root;
    	
    	if(rootNode == null) {
			return false;
		}
		
    	while((rootNode != null)) {
    		String rootWord = rootNode.getWord();
    		if(rootWord.compareTo(word) > 0){
    			rootNode = rootNode.left;
    		}else if(rootWord.compareTo(word) < 0){
    			rootNode = rootNode.right;
            }else if(rootWord.compareTo(word) == 0 && flag==true){
            	rootNode.setWordCount(rootNode.getWordCount() + 1);
            	stats[0]=stats[0]+1;
            	found = true;
            	break;
            }else if(rootWord.compareTo(word) == 0 && flag==false){
            	if (rootNode.getWordCount()>0) {
            		rootNode.setWordCount(rootNode.getWordCount() - 1);
                	stats[0]=stats[0]-1;
                	if(rootNode.getWordCount()==0){
                		MyLogger.writeMessage("Count for word: " + rootNode.getWord() + " is zero now", MyLogger.DebugLevel.IN_RESULTS);
                	}
                	found = true;
                	break;
				}
            }
    	}
    	return found;
    }
    
    private void traverseBSTTree() {
    	inorderTraverseBST(root,stats);
    }
    
    /**
     * Function to inorder traverse a tree and compute character count and distinct word count
     * @param rootNode
     * @param statsIn
     */
    private void inorderTraverseBST(Node rootNode, int[] statsIn)  {
    	if(rootNode != null) {
			inorderTraverseBST(rootNode.left, statsIn);
			if(rootNode.getWordCount()>0){
				stats[2] = stats[2]+1;
				stats[1] = stats[1] + (rootNode.getWordCount() * rootNode.getCharacterCnt());
			}
			//System.out.println(rootNode.getWord() + " " + rootNode.getWordCount() + " " + rootNode.getCharacterCnt());
			inorderTraverseBST(rootNode.right,statsIn);
		}
	}
    
    /**
     * This method is used to get the computed results of all 3 operations
     * @return
     */
    public String getStats() {
    	traverseBSTTree();
    	StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("The total number of words: " + stats[0] + "\n");
		stringBuilder.append("The total number of characters: " + stats[1] + "\n");
		stringBuilder.append("The total number of distinct words: " + stats[2]);
		return stringBuilder.toString();
	}
}

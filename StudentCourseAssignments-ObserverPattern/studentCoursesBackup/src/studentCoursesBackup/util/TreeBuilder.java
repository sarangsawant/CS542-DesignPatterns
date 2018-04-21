package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {

	Node originalRoot;
	Node backupRoot1 , backupRoot2;
	
	public TreeBuilder() {
		originalRoot = null;
		backupRoot1 = null;
		backupRoot2 = null;
	}
	
	public Node getOriginalRoot() {
		return originalRoot;
	}

	public void setOriginalRoot(Node originalRoot) {
		this.originalRoot = originalRoot;
	}

	/**
	 * This method returns a new Node object by setting b number and creating new arraylist 
	 * @param str
	 * @return
	 */
	public Node createNode(String str) {
		Node node = new Node();
		String arr[] = str.split(":");
		
		node.setbNumber(Integer.parseInt(arr[0]));
		
		ArrayList<String> list = new ArrayList<>();
		list.add(arr[1]);
		node.setCourses(list);
		
		return node;
	}
	
	/**
	 * This function creates and inserts nodes in respective tree i.e original, backup1 and backup 2
	 * @param node
	 * @param backupNode1
	 * @param backupNode2
	 */
    public void insertNodesInBST(Node node, Node backupNode1, Node backupNode2) {
    	originalRoot = insertNodeToBST(originalRoot, node);
    	
    	backupRoot1 = insertNodeToBST(backupRoot1, backupNode1);
    	backupRoot2 = insertNodeToBST(backupRoot2, backupNode1);
    }
    
    /**
     * This is a recursive function to insert node to Binary tree. Helper function for insertNodesInBST 
     * @param root
     * @param node
     * @return
     */
	private Node insertNodeToBST(Node rootNode, Node node) {
		
		if(rootNode == null) {
			rootNode = node;
			return rootNode;
		}
		 /* Otherwise, recur down the tree */
        if (node.getbNumber() < rootNode.getbNumber())
        	rootNode.left = insertNodeToBST(rootNode.left, node);
        else if (node.getbNumber() > rootNode.getbNumber())
        	rootNode.right = insertNodeToBST(rootNode.right, node);
 
        return rootNode;
	}
	
	/**
	 * This function is used to search bNumber in original tree
	 * @param bNumber
	 * @return true if bNumber present, else false
	 */
	public boolean searchBNumber(int bNumber) {
        return search(originalRoot, bNumber);
    }
 
    /**
     * Function to search for an element recursively. Helper function for searchBNumber 
     * Reference: http://www.sanfoundry.com/java-program-implement-binary-search-tree/
     * @param rootNode
     * @param bNumber
     * @return
     */
    private boolean search(Node rootNode, int bNumber) {
        boolean found = false;
        while ((rootNode != null) && !found) {
            int rval = rootNode.getbNumber();
            if (bNumber < rval)
            	rootNode = rootNode.left;
            else if (bNumber > rval)
            	rootNode = rootNode.right;
            else {
                found = true;
                break;
            }
            found = search(rootNode, bNumber);
        }
        return found;
    }
    
    /**
     * This function add course to existing node(bNumber) in BST. If node is not present or course already present then
     * new course is ignored
     * Reference: http://www.sanfoundry.com/java-program-implement-binary-search-tree/
     * @param bNumber
     * @param courseName
     * @return
     */
    public boolean addCourseToExistingBNumber(int bNumber, String courseName) {
    	boolean found = false;
    	Node root = originalRoot;
    	
    	if(root == null) {
			return false;
		}
		
    	 while ((root != null)) {
             int rval = root.getbNumber();
             if (bNumber < rval)
             	root = root.left;
             else if (bNumber > rval)
             	root = root.right;
             else if(bNumber == rval){
            	 
            	 for(String s : root.getCourses()) {
            		 if(s.equals(courseName)) {
            			 return false;
            		 }
            	 }
                 found = true;
                 root.getCourses().add(courseName);
                 
                 root.update(courseName,bNumber);
                 
                 break;
             }
         }
    	 return found;
    }
    
    /**
     * This function is used to delete course from the original tree and notify its observers for deletion
     * Reference: http://www.sanfoundry.com/java-program-implement-binary-search-tree/
     * @param bNumber
     * @param courseName
     * @return
     */
    public boolean deleteCourse(int bNumber, String courseName) {
    	boolean found = false;
    	Node root = originalRoot;
    	
    	if(root == null) {
			return false;
		}
		
    	 while ((root != null)) {
             int rval = root.getbNumber();
             if (bNumber < rval)
             	root = root.left;
             else if (bNumber > rval)
             	root = root.right;
             else if(bNumber == rval){
                 found = true;
                 root.getCourses().remove(courseName);
                 
                 root.notifyObservers(bNumber, courseName);
                 
                 break;
             }
         }
    	 return found;
    }
    
    /**
     * This function traverses a tree and populates results list in non-decreasing order
     * @param rootNode
     * @param result
     */
    private void inorderTraverseBST(Node rootNode, Results result)  {
		 if (rootNode != null) {
			 	inorderTraverseBST(rootNode.left, result);
	            result.addBNumberAndCourses(rootNode.getbNumber(), rootNode.getCourses());
			 	inorderTraverseBST(rootNode.right, result);
	        }
	}
    
    /**
     * This function is used to populate results of all the trees
     * @param OriginalResults
     * @param backupResults1
     * @param backupResults2
     */
    public void printNodes(Results OriginalResults, Results backupResults1, Results backupResults2) {
    	inorderTraverseBST(originalRoot, OriginalResults);
    	inorderTraverseBST(backupRoot1, backupResults1);
    	inorderTraverseBST(backupRoot2, backupResults2);
    }
}

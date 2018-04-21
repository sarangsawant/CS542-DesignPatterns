package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements SubjectI, ObserverI, Cloneable{

	private int bNumber;
	private ArrayList<String> courses;
	public Node left,right;
	
	private ArrayList<Node> backupNodes = new ArrayList<>();
	
	public Node() {
		left = null;
		right = null;
		bNumber = 0;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return new Node();
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
	
	public int getbNumber() {
		return bNumber;
	}
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	
	public ArrayList<String> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	@Override
	public void update(String course, int bNum) {
		for(Node node : backupNodes) {
			node.getCourses().add(course);
			node.setbNumber(bNum);
		}
		
	}

	@Override
	public void registerObserver(Node observer) {
		backupNodes.add(observer);
	}

	@Override
	public void removeObserver(Node observer) {
		backupNodes.remove(observer);
	}

	@Override
	public void notifyObservers(int bNumber, String courseName) {
		for(Node node : backupNodes) {
			node.getCourses().remove(courseName);
		}
		
	}

	public ArrayList<Node> getBackupNodes() {
		return backupNodes;
	}

	public void setBackupNodes(ArrayList<Node> backupNodes) {
		this.backupNodes = backupNodes;
	}
	
	
	
}

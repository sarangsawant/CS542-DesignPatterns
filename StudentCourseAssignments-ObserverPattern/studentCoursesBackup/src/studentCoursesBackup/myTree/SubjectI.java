package studentCoursesBackup.myTree;

public interface SubjectI {

	public void registerObserver(Node observer);
	public void removeObserver(Node observer);
	public void notifyObservers(int bNumber, String course);
	
}

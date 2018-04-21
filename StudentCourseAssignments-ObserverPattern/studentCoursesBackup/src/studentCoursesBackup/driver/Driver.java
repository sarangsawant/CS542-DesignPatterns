package studentCoursesBackup.driver;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {

	public static void main(String[] args) {
		
		if(args.length == 5) {
			String INPUT_FILENAME = args[0];
			String DELETE_FILENAME = args[1];
			String OUTPUT1_FILENAME = args[2];
			String OUTPUT2_FILENAME = args[3];
			String OUTPUT3_FILENAME = args[4];

			FileProcessor fileProcessor = new FileProcessor();
			fileProcessor.openFile(INPUT_FILENAME);
			 		
			TreeBuilder treeBuilder = new TreeBuilder();
			Node node;
			Node backupNode1 = null, backupNode2 = null;
			int bNumber;
			
			String line = "";
			while (line != null) {
				line = fileProcessor.readLine();

				if(line != null) {
					String arr[] = line.split(":");
					bNumber = Integer.parseInt(arr[0]);
					//If it is new bNumber
					if(!treeBuilder.searchBNumber(bNumber)) {
						node = treeBuilder.createNode(line);
						
						int bNum = node.getbNumber();
						ArrayList<String> list1 = new ArrayList<>();
						ArrayList<String> list2 = new ArrayList<>();
						
						for(String course : node.getCourses()) {
							list1.add(course);
							list2.add(course);
						}
						
						try {
							backupNode1 = (Node) node.clone();
							backupNode1.setbNumber(bNum);
							backupNode1.setCourses(list1);
							
							backupNode2 = (Node) node.clone();
							backupNode2.setbNumber(bNum);
							backupNode2.setCourses(list2);
							
							node.registerObserver(backupNode1);
							node.registerObserver(backupNode2);
							
						} catch (CloneNotSupportedException e) {
							System.out.println("Error while cloning backup nodes..!");
							e.printStackTrace();
							System.exit(0);
						}
						
						treeBuilder.insertNodesInBST(node, backupNode1, backupNode2);
					}else {
						String arr1[] = line.split(":");
						treeBuilder.addCourseToExistingBNumber(Integer.parseInt(arr1[0]), arr1[1]);
					}
				}
			}
			
			//Code for delete
			FileProcessor fileProcessor1 = new FileProcessor();
			fileProcessor1.openFile(DELETE_FILENAME);
			
			line = "";
			while(line != null) {
				line = fileProcessor1.readLine();
				
				if(line != null) {
					String arr[] = line.split(":");
					treeBuilder.deleteCourse(Integer.parseInt(arr[0]), arr[1]);
				}
			
			}
			
			
			Results originalResults = new Results();
	    	Results backupResults1 = new Results();
	    	Results backupResults2 = new Results();
	    	
	    	//store metadata to results objects
			treeBuilder.printNodes(originalResults, backupResults1, backupResults2);
			
			originalResults.writeToFile(OUTPUT1_FILENAME);
			originalResults.writeToFile(OUTPUT2_FILENAME);
			originalResults.writeToFile(OUTPUT3_FILENAME);
		}else {
			System.out.println("Incorrect number of arguments");
			System.exit(0);
		}
	}
}

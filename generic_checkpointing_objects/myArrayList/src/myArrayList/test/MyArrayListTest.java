package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {

	private String testName;
	private String template;
	private final String PASSED = "Passed";
	private final String FAILED = "Failed";
	
	public void testMe(MyArrayList myArrayList, Results results) {
		testDynamicallyIncreaseArraySize(myArrayList, results);

		testArraySizeAfterInsertingRemovingElements(myArrayList, results);

		testInitializeArrayFunction(myArrayList, results);
		
		testRemoveSingleOccurranceElement(myArrayList, results);
		
		testRemoveMultipleOccurranceElement(myArrayList, results);
		
		testSumArrayFuncAfterInsertNewElementFunction(myArrayList, results);
		
		testSumArrayFuncAfterRemovingElementFunction(myArrayList, results);
		
		testIndexOfFuncForElementPresent(myArrayList, results);
		
		testIndexOfFuncForElementNotPresent(myArrayList, results);

		testInsertSortedFunction(myArrayList, results);
	}
	
	private void testDynamicallyIncreaseArraySize(MyArrayList myArrayList, Results results){
		testName = "50% Increase in Array Size after array exceeds its original size";
		
		int initialSize = myArrayList.size();
		int array[] = myArrayList.getArray();
		
		if(initialSize == array.length){
			int value = 121;
			myArrayList.insertSorted(value);
			array = myArrayList.getArray();
			if(array.length == (initialSize + (initialSize/2)))
				template = results.generateResultFormat(testName, PASSED,"");
			else
				template = results.generateResultFormat(testName, FAILED,"Array Size not increased");
		}else
				template = results.generateResultFormat(testName,PASSED,"");
		
		results.storeNewResult(template);
	}
	
	private void testArraySizeAfterInsertingRemovingElements(MyArrayList myArrayList, Results results){
		testName = "Check Array Size After inserting and removing elements";
		int insertElement1 = 5;
		int insertElement2 = 6;
		int insertElement3 = 7;
		int removeElement1 = 0;
		
		int arraySize = myArrayList.size();
		myArrayList.insertSorted(insertElement1);
		myArrayList.insertSorted(insertElement2);
		myArrayList.insertSorted(insertElement3);

		myArrayList.removeValue(removeElement1);
		
		int expectedSize = myArrayList.size();
		
		if((arraySize+2) == expectedSize)
			template = results.generateResultFormat(testName, PASSED, "");
		else
			template = results.generateResultFormat(testName, FAILED, "Incorrect array size");

		results.storeNewResult(template);
	}
	
	private void testInitializeArrayFunction(MyArrayList myArrayList, Results results){
		int testArray[] = new int[10];
		int flag = 1;
		testName = "Initialize Array Elements";

		testArray = myArrayList.initializeArray(testArray);
		int index;
		for(index=0; index<testArray.length; index++){
			if(testArray[index] != 999999){
				flag = 0;
				break;
			}
		}
		
		if(flag == 1)
			template = results.generateResultFormat(testName, PASSED, "");
		else 
			template = results.generateResultFormat(testName, FAILED, "Array initialization failed");
		
		results.storeNewResult(template);

	}
	
	private void testRemoveSingleOccurranceElement(MyArrayList myArrayList, Results results){
		int removeElement = 10;
		int flag = 1;
		testName = "Remove Single Occuring Element from Array";
		
		myArrayList.removeValue(removeElement);
		
		int array[] = myArrayList.getArray();
		int index;
		for(index=0; index<array.length; index++){
			if(array[index] == removeElement){
				flag = 0;
				break;
			}
		}
		
		if(flag == 1)
			template = results.generateResultFormat(testName, PASSED, "");
		else
			template = results.generateResultFormat(testName, FAILED, "Element to be removed not present in array");
		
		results.storeNewResult(template);
	}
	

	private void testRemoveMultipleOccurranceElement(MyArrayList myArrayList, Results results){
		int removeElement = 3;
		int flag = 1;
		testName = "Remove Multiple Occuring Elements form Array";
		
		myArrayList.removeValue(removeElement);
		
		int array[] = myArrayList.getArray();
		int index;
		for(index=0; index<array.length; index++){
			if(array[index] == removeElement){
				flag = 0;
				break;
			}
		}
		
		if(flag == 1)
			template = results.generateResultFormat(testName,PASSED, "");
		else
			template = results.generateResultFormat(testName, FAILED, "Element's to be removed are not present in array");
		
		results.storeNewResult(template);
	}
	
	private void testSumArrayFuncAfterInsertNewElementFunction(MyArrayList myArrayList, Results results){
		int num = 10;
		int expectedSum = myArrayList.sum() + num;
		int sum;
		testName = "Test Sum of Array Elements after adding new Element";
		
		myArrayList.insertSorted(num);
		sum = myArrayList.sum();
		
		template="";
		if(expectedSum == sum)
			template = results.generateResultFormat(testName, PASSED, "");
		else
			template = results.generateResultFormat(testName, FAILED, "Incorrect sum of array elements after adding new number");
		
		results.storeNewResult(template);
	}
	
	private void testSumArrayFuncAfterRemovingElementFunction(MyArrayList myArrayList, Results results){
		int num = 10;
		int expectedSum = myArrayList.sum() - num;;
		int sum;
		testName = "Test Sum of Array Elements after removing existing element from array";
		
		myArrayList.removeValue(num);
		sum = myArrayList.sum();
		
		template="";
		if(expectedSum == sum)
			template = results.generateResultFormat(testName, PASSED, "");
		else
			template = results.generateResultFormat(testName, FAILED, "Incorrect sum of array elements after removing an element");
		
		results.storeNewResult(template);
	}
	
	private void testIndexOfFuncForElementPresent(MyArrayList myArrayList, Results results){
		testName = "Index of Element present in array";
		int array[] = myArrayList.getArray();
		int element = 0 ;
		if(array.length > 0)
			element = array[0];
		
		int expectedIndex = 0;
		
		int index = myArrayList.indexOf(element);
		
		if(index == -1){
			template = results.generateResultFormat(testName, FAILED, "Element '0' not present in array");
		}else{
			if(expectedIndex == index)
				template = results.generateResultFormat(testName, PASSED, "");
			else
				template = results.generateResultFormat(testName, FAILED, "Incorrect index of element " + element);
			
		}
		results.storeNewResult(template);
	}
	
	private void testIndexOfFuncForElementNotPresent(MyArrayList myArrayList, Results results){
		testName = "Index of Element NOT present in array";
		int element = 565656;
		int expectedIndex = -1;
		int index = myArrayList.indexOf(element);
		
		if(expectedIndex == index)
			template = results.generateResultFormat(testName, PASSED, "");
		else
			template = results.generateResultFormat(testName, FAILED, "Incorrect index returned by function 'indexOf'");
		
		results.storeNewResult(template);
	}
	
	private void testInsertSortedFunction(MyArrayList myArrayList, Results results){
		int value = 20;
		testName = "Insert Element in Array and Sort";

		myArrayList.insertSorted(value);
		
		int array[] = myArrayList.getArray();
		int index;
		int flag = 0;
		for(index=0; index < array.length-1; index++){
			if(array[index] > array[index+1])
				flag = 1;
		}
		
		if(flag == 0)
			template = results.generateResultFormat(testName, PASSED, "");
		else
			template = results.generateResultFormat(testName, FAILED, "Array elements are not in sorted order");
		
		results.storeNewResult(template);
	}
}

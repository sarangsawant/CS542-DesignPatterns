package myArrayList;

import java.util.Arrays;

public class MyArrayList {

	int array[] = new int[50];
	int i, arraySize;
	private static final int MAX_VALUE = 999999;
	
	/**
	 * Constructor to initialize data members
	 */
	public MyArrayList() {
		int j;
		for(j=0; j<array.length; j++) {
			array[j] = MAX_VALUE;
		}
		arraySize = array.length;
		i = 0;
	}
	
	/**
	 * This method is used to insert integer number into array. It increases array size by 50%, if array if full.
	 * @param value
	 */
	private void insertInputValueToArray(int value) {

		if (i >= arraySize) {
			arraySize += arraySize / 2;

			int newArray[] = new int[arraySize];
			newArray = initializeArray(newArray);
			newArray = copyOldArray(array, newArray);
			
			array = newArray;
		}
		//Insert value in array and increment its count
			array[i] = value;
			i += 1;		
	}

	/**
	 * This method is used to copy elements of oldArray to new Array of increased size.
	 * @param oldArray
	 * @param newArray
	 * @return
	 */
	private int[] copyOldArray(int[] oldArray, int[] newArray) {
		int index;
		for (index = 0; index < oldArray.length; index++) {
			newArray[index] = oldArray[index];
		}
		
		return newArray;
	}

	/**
	 * This method is used to initialize array by large value 999999
	 * @param array
	 * @return
	 */
	public int[] initializeArray(int[] array) {
		int index;
		for(index=0; index<array.length; index++) {
			array[index] = MAX_VALUE;
		}
		return array;
	}
	
	public void displayArray() {
		int index;
		for(index=0; index<array.length; index++){
			if(array[index] != MAX_VALUE)
				System.out.print(array[index] + " ");
		}
	}

	public void sortArray() {
		Arrays.sort(array);
	}
	
	/**
	 *  This method insert's new value and sorts array in ascending order. 
	 * @param newValue
	 */
	public void insertSorted(int newValue) {
		insertInputValueToArray(newValue);
		sortArray();
	}
	
	/**
	 * This method remove all occurences of a value and re-arrange array in ascending order.
	 * @param value
	 */
	public void removeValue(int value) {
		int index = 0;
		for(index = 0; index < array.length; index++ ) {
			if(array[index] == value)
				array[index] = MAX_VALUE;
		}
		sortArray();
	}
	
	/**
	 * This method return's the index of the first occurrence a value. Return -1 if the value absent.
	 * @param value
	 */
	public int indexOf(int value) {
		int index;
		for(index = 0; index < array.length; index++) {
			if(array[index] == value)
				return index;
		}
		return -1;
	}

	/**
	 * This method return the total number of values that are stored in the array list.
	 * @return
	 */
	public int size() {
		int index, count=0;
		for(index=0; index<array.length; index++) {
			if(array[index] != MAX_VALUE)
				count += 1;
		}
		return count;
	}
	
	/**
	 * This method return's the sum of all values that are stored in the array list.
	 * @return
	 */
	public int sum() {
		int index, sum=0;
		for(index=0; index<array.length; index++) {
			if(array[index] != MAX_VALUE) {
				sum += array[index];
			}
		}
		return sum;
	}
	
	@Override
	public String toString() {
		return "Driver [array=" + Arrays.toString(array) + "]";
	}

	public int[] getArray() {
		return array;
	}

}

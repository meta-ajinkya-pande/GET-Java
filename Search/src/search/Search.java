package search;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Design a class “Search” to search for an element in an array 
 * using recursion following strategy 
 * - Linear Search
 * - Binary Search
 * 
 */
public class Search {

	/*
	 * Linear search
	 */
	private static int linearSearchUtility(int[] arr, int left, int right,
			int ele) {

		if (right < left) // if element is not found in whole array, return -1
			return -1;

		if (arr[left] == ele) // if element found from left side, return index
			return left;

		if (arr[right] == ele) // if element found from right side, return index
			return right;

		return linearSearchUtility(arr, left + 1, right - 1, ele);
	}

	/*
	 * Binary search
	 */
	private static int binarySearchUtility(int[] arr, int left, int right,
			int ele) {
		if (right >= left) {
			int mid = left + (right - left) / 2;

			// If the element is present at the middle itself
			if (arr[mid] == ele)
				return mid;

			// If element is smaller than mid, then it can only be present in
			// left sub array
			if (arr[mid] > ele)
				return binarySearchUtility(arr, left, mid - 1, ele);

			// Else the element can only be present in right sub array
			return binarySearchUtility(arr, mid + 1, right, ele);
		}

		// We reach here when element is not found in array
		return -1;
	}

	public static int linearSearch(int[] arr, int len, int ele) {
		int index = -1;
		// check array index out of range exception
		if (len == arr.length - 1)
			index = Search.linearSearchUtility(arr, 0, len, ele);
		else
			index = Search.linearSearchUtility(arr, 0, len - 1, ele);

		// modify the index value to user understandable value
		if (index != -1)
			return index + 1;

		return index;
	}

	public static int binarySearch(int[] arr, int len, int ele) {
		// array is sorted for binary search in ascending order
		Arrays.sort(arr);
		int index = -1;
		// check array index out of range exception
		if (len == arr.length - 1)
			index = Search.binarySearchUtility(arr, 0, len, ele);
		else
			index = Search.binarySearchUtility(arr, 0, len - 1, ele);

		if (index != -1)
			return index + 1;

		return index;
	}

	public static void main(String[] args) {

		int[] arr;
		int arrLen;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		arrLen = input.nextInt();
		arr = new int[arrLen];
		System.out.println("Enter " + arrLen + " elements: ");
		for (int i = 0; i < arrLen; i++) {
			arr[i] = input.nextInt();
		}

		boolean flag = true; // for looping while loop

		while (flag) {
			System.out.println("MENU : \n" + "1. Linear Search \n"
					+ "2. Binary Search \n" + "0. Exit \n");

			System.out.println("Enter your choice: ");
			int choice = input.nextInt();
			switch (choice) {
			case 0:
				System.exit(1);

			case 1:
				System.out.println("Enter element to be searched: ");
				int ele = input.nextInt();
				int index = Search.linearSearch(arr, arrLen - 1, ele);

				if (index == -1)
					System.out.println("Element not found in the array\n");
				else
					System.out.println("Element " + ele + " found at index : "
							+ index + "\n");
				break;

			case 2:
				System.out.println("Enter element to be searched: ");
				ele = input.nextInt();

				// this function will sort the array and send index
				index = Search.binarySearch(arr, arrLen - 1, ele);

				if (index == -1)
					System.out.println("Element not found in the array\n");
				else
					System.out.println("Element " + ele + " found at index : "
							+ index + "\n");
				break;
			default:
				System.out.println("Enter valid choice !");
			}
		}

		input.close(); // Scanner input closed

	}

}
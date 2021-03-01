package operations;

import java.util.Scanner;

public class ArrOperation {
	Scanner in = new Scanner(System.in);
	int[] arr;
	int noOfItems;

	public ArrOperation() {
		System.out.println("Enter number of elements: ");
		noOfItems = in.nextInt();
		System.out.println("Enter " + noOfItems + " elements: ");
		arr = new int[noOfItems];
		for (int i = 0; i < noOfItems; i++) {
			arr[i] = in.nextInt();
		}
	}

	// display array
	private void displayArray(int arr[]) {
		System.out.println("Array elements: ");
		for (int i = 0; i < noOfItems; i++) {
			System.out.println(arr[i]);
		}
	}

	// largest mirror
	private void largestMirror() {

	}

	// number of clumps
	private int noOfClumps() {
		int clumps = 0, count = 1;
		for (int i = 0; i < noOfItems-1; i++) {
			if (arr[i + 1] == arr[i]) {
				count++;
			} else {
				if (count >= 2) {
					clumps++;
				}
				count = 1;
			}
		}
		if(arr[noOfItems-2]==arr[noOfItems-1]){
			clumps++;
		}
		return clumps;
	}

	// fit XY
	private void fitXY() {

	}

	// split equal array
	private int splitEqual() {
		int index = -1, sumLeft = 0, sumRight = 0, i = 0, j = noOfItems - 1, k = 0;
		while (k != noOfItems) {
			if (sumLeft < sumRight) {
				sumLeft += arr[i];
				i++;
				k++;
			} else if (sumLeft > sumRight) {
				sumRight += arr[j];
				j--;
				k++;
			} else if (sumLeft == sumRight) {
				sumLeft += arr[i];
				sumRight += arr[j];
				i++;
				j--;
				k += 2;
			}
		}
		if (sumLeft == sumRight) {
			index = j + 1;
		} else {
			index = -1;
		}
		return index;
	}

	public static void main(String[] args) {
		ArrOperation obj = new ArrOperation();
		obj.displayArray(obj.arr);

		// split array
		System.out.println("\nSplit array at: ");
		System.out.print(obj.splitEqual());

		// clumps in array
		System.out.println("\nTotal clumps: ");
		System.out.print(obj.noOfClumps());
	}

}

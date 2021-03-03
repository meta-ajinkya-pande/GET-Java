package operations;

import java.util.Scanner;

public class ArrOperation {
	Scanner in = new Scanner(System.in);
	int[] arr;
	int noOfItems;

	public static boolean checkArray(int[] arr) {
		boolean correct = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				correct = false;
				break;
			}
		}

		return correct;
	}

	public void init() {
		System.out.println("Enter number of elements: ");
		noOfItems = in.nextInt();
		System.out.println("Enter " + noOfItems + " elements: ");
		arr = new int[noOfItems];
		for (int i = 0; i < noOfItems; i++) {
			arr[i] = in.nextInt();
		}
	}

	// display array
	public void displayArray(int arr[]) {
		System.out.println("Array elements: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	// largest mirror
	public int largestMirror(int[] arr) {
		if (arr.length == 0) {
			throw new AssertionError("Array is empty");
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = arr.length - 1; j >= 0 && i + count < arr.length; j--) {
				if (arr[i + count] == arr[j]) {
					count++;
				} else {
					max = Math.max(max, count);
					count = 0;
				}
			}

			max = Math.max(max, count);
		}

		return max;
	}

	// number of clumps
	public int noOfClumps(int[] arr) {
		if (arr.length == 0) {
			throw new AssertionError("Array is empty");
		}
		noOfItems = arr.length;

		int clumps = 0, count = 1;
		for (int i = 0; i < noOfItems - 1; i++) {
			if (arr[i + 1] == arr[i]) {
				count++;
			} else {
				if (count >= 2) {
					clumps++;
				}
				count = 1;
			}
		}
		if (count >= 2) {
			clumps++;
		}
		return clumps;
	}

	// fit XY
	public int[] fitXY(int[] arr, int x, int y) {
		noOfItems = arr.length;
		int countX = 0, countY = 0, len = arr.length;
		// array empty
		if (arr.length == 0) {
			throw new AssertionError("Array is empty");
		}
		// X at last
		if (arr[(noOfItems - 1)] == x) {
			throw new AssertionError("X is at last position");
		}
		// repeated x
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] == x && arr[i + 1] == x) {
				throw new AssertionError("Adjacent X values present");
			}
		}

		for (int i = 0; i < len; i++) {
			if (arr[i] == x) {
				countX++;
			}
			if (arr[i] == y) {
				countY++;
			}
		}
		if (countY < countX) {
			throw new AssertionError(
					"X and Y count not equal or count of X is less than Y");
		}
		int[] indexX = new int[countX];
		int[] indexY = new int[countY];

		int j = 0, k = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] == x) {
				indexX[j++] = i + 1;
			}
			if (arr[i] == y) {
				indexY[k++] = i;
			}
		}
		int temp = 0;
		for (int i = 0; i < countX; i++) {
			temp = arr[indexX[i]];
			arr[indexX[i]] = arr[indexY[i]];
			arr[indexY[i]] = temp;
		}
		return arr;
	}

	// split equal array
	public int splitEqual(int[] arr) {
		if (arr.length == 0) {
			throw new AssertionError("Array is empty");
		}
		noOfItems = arr.length;
		int index = -1, sumLeft = 0, sumRight = 0, i = 0, j = noOfItems - 1, k = 0;

		while (k < noOfItems) {
			if (i == j) {
				if (sumLeft < sumRight) {
					sumLeft += arr[i];
					i++;
				} else {
					sumRight += arr[j];
					j--;
				}
				break;
			}
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
		obj.init();
		obj.displayArray(obj.arr);
		Scanner in = new Scanner(System.in);

		if (checkArray(obj.arr) == true) {
			// split array
			System.out.println("\nSplit array at: ");
			System.out.print(obj.splitEqual(obj.arr));

			// clumps in array
			System.out.println("\nTotal clumps: ");
			System.out.print(obj.noOfClumps(obj.arr));

			// largest mirror
			System.out.println("\nLargest Mirror: ");
			System.out.print(obj.largestMirror(obj.arr));

			// fitXY
			System.out.println("\n\nFitting XY: ");
			System.out.println("Enter X and Y: ");
			int[] array = obj.fitXY(obj.arr, in.nextInt(), in.nextInt());
			System.out.println("\nAfter fitting XY: ");
			obj.displayArray(array);
		} else {
			System.out.println("\nInput array contains negative integers !");
		}
		in.close();
	}
}

package operations;

import java.util.Scanner;

public class ArrOperation {
	Scanner in = new Scanner(System.in);
	int[] arr;
	int noOfItems;

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
		for (int i = 0; i < noOfItems; i++) {
			System.out.println(arr[i]);
		}
	}

	// largest mirror
	public int largestMirror(int[] arr) {
		noOfItems = arr.length;
		int len = arr.length;
		if (len == 0)
			return 0;
		int maxCount = 1;
		boolean flag = false;

		for (int i = 0; i < len; i++) {
			int tempCount = 1;
			int count = i;

			for (int j = len - 1; j >= 0; j--) {
				if (arr[count] == arr[j]) {
					if (flag) {
						tempCount++;
						maxCount = Math.max(tempCount, maxCount);
					}
					flag = true;
					count++;
					if (count >= len)
						break;
				} else if (arr[i] != arr[j] && flag) {
					flag = false;
					count = i;
					tempCount = 1;
				} else if (j == count || j == (count + 1)) {
					flag = false;
					break;
				}
			}
		}
		return maxCount;
	}

	// number of clumps
	public int noOfClumps(int[] arr) {
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

		if (arr.length == 0 || x == arr[noOfItems - 1]) {
			int emptyArr[] = new int[0];
			return emptyArr;
		}

		for (int i = 0; i < len; i++) {
			if (arr[i] == x) {
				countX++;
			}
			if (arr[i] == y) {
				countY++;
			}
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
		System.out.println("\nFitting XY: ");
		System.out.println("\nEnter X and Y: ");
		obj.displayArray(obj.fitXY(obj.arr, in.nextInt(), in.nextInt()));
		System.out.println("\nAfter fitting XY: ");
		obj.displayArray(obj.arr);

		in.close();
	}

}

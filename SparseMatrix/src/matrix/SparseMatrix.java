package matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class SparseMatrix {

	ArrayList<MatrixCoordinates> list = new ArrayList<MatrixCoordinates>();
	private int size;
	Scanner input = new Scanner(System.in);

	private void initMatrix() {
		int i, j, m, n, val;
		System.out.println("Enter the size of matrix: ");
		size = input.nextInt();
		n = size;
		System.out.println("Enter " + (size * size) + " elements: ");
		for (i = 0; i < size; i++) {
			for (j = 0; j < n; j++) {
				val = input.nextInt();
				if (val != 0) {
					MatrixCoordinates obj = new MatrixCoordinates(i, j, val);
					list.add(obj);
				}
			}
		}
	}

	// get value
	private int getMatValue(ArrayList<MatrixCoordinates> list, int x, int y) {
		int value = 0;
		int len = list.size();
		for (int i = 0; i < len; i++) {
			if (list.get(i).x == x && list.get(i).y == y) {
				value = list.get(i).val;
			}
		}
		return value;
	}

	// sort list
	private ArrayList<MatrixCoordinates> sortList(
			ArrayList<MatrixCoordinates> arr) {
		ArrayList<MatrixCoordinates> sortedArr = new ArrayList<MatrixCoordinates>();
		int len = arr.size();
		int val = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				val = getMatValue(arr, i, j);
				if (val != 0) {
					MatrixCoordinates obj = new MatrixCoordinates(i, j, val);
					sortedArr.add(obj);
				}
			}
		}
		return sortedArr;
	}

	// display matrix
	private void displayMatrix(ArrayList<MatrixCoordinates> list) {
		System.out.println("Matrix: ");
		int lSize = list.size(); // 4
		int k = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (k != lSize) {
					if (list.get(k).x == i && list.get(k).y == j) {
						System.out.print(list.get(k).getValue() + " ");
						k += 1;
					} else {
						System.out.print("0 ");
					}
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println("\n");
		}
	}

	// check sparse
	private void checkSparse() {
		if (list.size() < ((size * size) / 2)) {
			System.out.println("This is Sparse Matrix");
		} else {
			System.out.println("This is not Sparse Matrix");
			System.out
					.println("NOTE: Sparse Matrix contains majority elements to be 0.");
		}
	}

	// transpose of the matrix
	private ArrayList<MatrixCoordinates> transpose() {
		ArrayList<MatrixCoordinates> arr = new ArrayList<MatrixCoordinates>();
		int len = list.size();
		for (int i = 0; i < len; i++) {
			MatrixCoordinates obj = new MatrixCoordinates(list.get(i).x,
					list.get(i).y, list.get(i).val);
			arr.add(obj);
		}
		int temp;
		for (int i = 0; i < len; i++) {
			temp = arr.get(i).x;
			arr.get(i).x = arr.get(i).y;
			arr.get(i).y = temp;
		}

		arr = sortList(arr);
		return arr;
	}

	// check whether it is a symmetrical matrix
	private int checkSymmetric(ArrayList<MatrixCoordinates> list2) {
		int flag = 0;
		int len1 = list.size(), len2 = list2.size();
		if (len1 != len2) {
			flag = 0;
			return flag;
		} else {
			for (int i = 0; i < len1; i++) {
				if (list.get(i).x == list2.get(i).x
						&& list.get(i).y == list2.get(i).y
						&& list.get(i).val == list2.get(i).val) {
					flag = 1;
				} else {
					flag = 0;
					return flag;
				}
			}
		}

		return flag;
	}

	// add two matrices
	private void addMatrix(SparseMatrix m1, SparseMatrix m2) {
		int lenM1 = m1.list.size(), lenM2 = m2.list.size();
		size = m1.size;
		// iterators
		int it1 = 0, it2 = 0;
		while (it1 < lenM1 && it2 < lenM2) {

			if (m1.list.get(it1).x == m2.list.get(it2).x) {
				if (m1.list.get(it1).y == m2.list.get(it2).y) {
					MatrixCoordinates obj = new MatrixCoordinates(
							m1.list.get(it1).x, m1.list.get(it1).y,
							m1.list.get(it1).val + m2.list.get(it2).val);
					list.add(obj);
					it1++;
					it2++;
				} else if (m1.list.get(it1).y < m2.list.get(it2).y) {
					MatrixCoordinates obj = new MatrixCoordinates(
							m1.list.get(it1).x, m1.list.get(it1).y,
							m1.list.get(it1).val);
					list.add(obj);
					it1++;
				} else if (m1.list.get(it1).y > m2.list.get(it2).y) {
					MatrixCoordinates obj = new MatrixCoordinates(
							m2.list.get(it2).x, m2.list.get(it2).y,
							m2.list.get(it2).val);
					list.add(obj);
					it2++;
				}
			} else if (m1.list.get(it1).x < m2.list.get(it2).x) {
				MatrixCoordinates obj = new MatrixCoordinates(
						m1.list.get(it1).x, m1.list.get(it1).y,
						m1.list.get(it1).val);
				list.add(obj);
				it1++;
			} else if (m1.list.get(it1).x > m2.list.get(it2).x) {
				MatrixCoordinates obj = new MatrixCoordinates(
						m2.list.get(it2).x, m2.list.get(it2).y,
						m2.list.get(it2).val);
				list.add(obj);
				it2++;
			}
		}
		// adding rest objects
		// for list 1
		while (it1 < lenM1) {
			MatrixCoordinates obj = new MatrixCoordinates(m1.list.get(it1).x,
					m1.list.get(it1).y, m1.list.get(it1).val);
			list.add(obj);
			it1++;
		}

		// for list 2
		while (it2 < lenM2) {
			System.out.println("\nM2 end loop:");
			MatrixCoordinates obj = new MatrixCoordinates(m2.list.get(it2).x,
					m2.list.get(it2).y, m2.list.get(it2).val);
			list.add(obj);
			it2++;
		}

	}

	// multiply two matrices
	private void multiply(SparseMatrix m1, SparseMatrix m2) {
		size = m1.size;
		int c;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c = 0;
				for (int k = 0; k < 3; k++) {
					c += m1.getMatValue(m1.list, i, k)
							* m2.getMatValue(m2.list, k, j);
				}
				MatrixCoordinates obj = new MatrixCoordinates(i, j, c);
				list.add(obj);
			}
		}
	}

	public static void main(String[] args) {
		// matrix m1
		System.out.println("Matrix 1:");
		SparseMatrix m1 = new SparseMatrix();
		m1.initMatrix();
		m1.displayMatrix(m1.list);
		m1.checkSparse();

		// transpose of M1
		ArrayList<MatrixCoordinates> arr = m1.transpose();
		System.out.println("\nTranspose of Matrix 1:");
		m1.displayMatrix(arr);

		// Symmetric
		int symmetric = 0;
		symmetric = m1.checkSymmetric(arr);
		if (symmetric == 1) {
			System.out.println("\nMatrix 1 is Symmetric !");
		} else {
			System.out.println("\nMatrix 1 is not Symmetric !");
		}

		// matrix m2
		System.out.println("\nMatrix 2:");
		SparseMatrix m2 = new SparseMatrix();
		m2.initMatrix();
		m2.displayMatrix(m2.list);
		m2.checkSparse();

		// Adding
		SparseMatrix m3 = new SparseMatrix();
		m3.addMatrix(m1, m2);
		System.out.println("\nAdding two matrices:");
		m3.displayMatrix(m3.list);
		// System.out.println("\nArr3:" + m3.list);

		// multiply
		SparseMatrix m4 = new SparseMatrix();
		m4.multiply(m1, m2);
		System.out.println("\nMultiply two matrices:");
		m4.displayMatrix(m4.list);
	}

}

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

	// transpose of the matrix [ERROR]
	private ArrayList<MatrixCoordinates> transpose() {
		ArrayList<MatrixCoordinates> arr = new ArrayList<MatrixCoordinates>();
		MatrixCoordinates obj;
		int len = list.size();
		arr.addAll(list);
		int temp;
		for (int i = 0; i < len; i++) {
			temp = arr.get(i).x;
			arr.get(i).x = arr.get(i).y;
			arr.get(i).y = temp;
		}
		System.out.println("\nTranspose:");
		displayMatrix(arr);
		return arr;
	}

	// check whether it is a symmetrical matrix
	// add two matrices
	private void addMatrix(SparseMatrix m1, SparseMatrix m2) {
		int lenM1 = m1.list.size(), lenM2 = m2.list.size();
		size = m1.size;
		// iterators
		int it1 = 0, it2 = 0;
		while (it1 < lenM1 || it2 < lenM2) {
			
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
			} else {
				if (m1.list.get(it1).x < m2.list.get(it2).x) {
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
		}

	}

	// multiply two matrices
	// list=[(0,1)
	public static void main(String[] args) {
		// matrix m1
		System.out.println("Matrix 1:");
		SparseMatrix m1 = new SparseMatrix();
		m1.initMatrix();
		m1.displayMatrix(m1.list);
		m1.checkSparse();
		ArrayList<MatrixCoordinates> arr = m1.transpose();
		System.out.println("\nArr:" + arr);
		// matrix m2
		System.out.println("\nMatrix 2:");
		SparseMatrix m2 = new SparseMatrix();
		m2.initMatrix();
		m2.displayMatrix(m2.list);
		m2.checkSparse();
		// addding
		SparseMatrix m3 = new SparseMatrix();
		m3.addMatrix(m1, m2);
		System.out.println("\nAdding two matrices:");
		m2.displayMatrix(m3.list);
		// multiply

	}

}

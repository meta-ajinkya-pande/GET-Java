package n_queens;

import java.util.*;

public class NQueensProblem {
	static final int MAX = 8; // maximum value of dimension of matrix i.e N
	static int dimensionOfMatrix;
	static int k = 1;

	/*
	 * @param board - get the board value in matrix
	 */
	static void printSolution(int board[][]) {
		System.out.printf("%d-\n", k++);
		for (int i = 0; i < dimensionOfMatrix; i++) {
			for (int j = 0; j < dimensionOfMatrix; j++)
				System.out.printf(" %d ", board[i][j]);
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}

	/**
	 * A recursive function to check if q queen can be placed on
	 * board[row][col]. Function is called when queen is already placed in 0 to
	 * col-1 for col value. So , this check only left side for attacking queens.
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @return boolean - true , if a queen can be placed at that column false,
	 *         otherwise
	 */
	static boolean isSafe(int board[][], int row, int col) {
		int i, j;

		// Check this row on left side
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		// Check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		// Check lower diagonal on left side
		for (i = row, j = col; j >= 0 && i < dimensionOfMatrix; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	/**
	 * A recursive utility function to solve dimensionOfMatrix Queen problem
	 * 
	 * @param board
	 *            - matrix to store queens position
	 * @param col
	 *            - column value in which queen can be placed by comparing in
	 *            each row , col and diagonal
	 * @return boolean
	 */
	static boolean solveNQUtil(int board[][], int col) {

		// base case: If all queens are placed then return true
		if (col == dimensionOfMatrix) {
			printSolution(board);
			return true;
		}

		/*
		 * Consider this column "col" and try placing this queen in all rows one
		 * by one
		 */
		boolean res = false;
		for (int i = 0; i < dimensionOfMatrix; i++) {
			/*
			 * Check if queen can be placed on board[i][col]
			 */
			if (isSafe(board, i, col)) {
				/* Place this queen in board[i][col] */
				board[i][col] = 1;

				// Make result true if any placement
				// is possible
				res = solveNQUtil(board, col + 1) || res;

				/*
				 * If placing queen in board[i][col] doesn't lead to a solution,
				 * then remove queen from board[i][col]
				 */
				board[i][col] = 0; // BACKTRACK
			}
		}

		/*
		 * If queen can not be place in any row in this column col then return
		 * false
		 */
		return res;
	}

	/*
	 * This function solves the n Queen problem using Backtracking. solveNQUtil
	 * returns false if queens cannot be placed, otherwise, return true and
	 * prints placement of queens on board. This function prints all possible
	 * solutions.
	 */
	static Boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {
		NQueensProblem.dimensionOfMatrix = dimensionOfMatrix;
		if (solveNQUtil(board, 0) == false) {
			System.out.printf("Solution does not exist");
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;

		int dimensionOfMatrix;

		do {
			System.out.println("Enter the dimension of N Queen problem : ");
			dimensionOfMatrix = input.nextInt();
			if (dimensionOfMatrix > NQueensProblem.MAX) {
				System.out.println("Exceed max value(8)!! ");
			}
			flag = false;
		} while (flag);

		int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];

		boolean res = nQueen(board, 0, dimensionOfMatrix);

	}
}
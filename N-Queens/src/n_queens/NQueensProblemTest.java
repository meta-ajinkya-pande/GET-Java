package n_queens;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class NQueensProblemTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void nQueensProbelmTest() {
		int dimensionOfMatrix = 4;
		int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];

		NQueensProblem qp = new NQueensProblem();

		boolean res = qp.nQueen(board, 0, dimensionOfMatrix);
		assertEquals(true, res);

	}

	@Test
	public void nQueensProbelmTest_Negative() {
		int dimensionOfMatrix = 3;
		int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];

		NQueensProblem qp = new NQueensProblem();

		boolean res = qp.nQueen(board, 0, dimensionOfMatrix);
		assertEquals(false, res);

	}

}
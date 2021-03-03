package search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void linearSeacrhTest() {
		int[] arr = { 5, 2, 3, 1, 4 };
		int arrLen = arr.length;

		// search 4 in array
		int index = Search.linearSearch(arr, arrLen, 4);
		assertEquals(5, index);

		// search 50 in array
		index = Search.linearSearch(arr, arrLen, 50);
		assertEquals(-1, index);
	}

	@Test
	public void binarySeacrhTest() {
		int[] arr = { 5, 2, 3, 1, 4 };
		int arrLen = arr.length;

		// in binary search, array is sorted
		// sorted array {6 , 7, 9, 13, 21, 45, 101, 102}

		// search 4 in array
		int index = Search.binarySearch(arr, arrLen, 4);
		assertEquals(4, index);

		// search 50 in array
		index = Search.binarySearch(arr, arrLen, 50);
		assertEquals(-1, index);
	}
}
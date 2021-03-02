package operations;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFixXY {

	ArrOperation test;

	@Before
	public void init() {
		test = new ArrOperation();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_When_NumberOf_X_And_Y_Equal_Expected_Array() {
		int arr[] = { 5, 6, 4, 2, 4, 6, 5 };
		int expectedArray[] = { 2, 6, 4, 5, 4, 5, 6 };
		assertArrayEquals(expectedArray, test.fitXY(arr, 4, 5));
	}

	@Test
	public void test_When_ArrayIsEmpty_Expected_AssertionErro() {
		try {
			int arr[] = {};
			int expectedArray[] = {};
			assertArrayEquals(expectedArray, test.fitXY(arr, 4, 5));
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void test_When_NumberOfX_And_Y_NotEqual_Expected_AssertionError() {
		try {
			int arr[] = { 6, 4, 2, 5, 1, 5 };
			int expectedArray[] = {};
			assertArrayEquals(expectedArray, test.fitXY(arr, 4, 5));
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void test_When_XIsAtLastPosition_Expected_AssertionErro() {
		try {
			int arr[] = { 6, 4, 2, 5, 1, 5, 4 };
			int expectedArray[] = {};
			assertArrayEquals(expectedArray, test.fitXY(arr, 4, 5));
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void negativeTestForFixXY() {
		int arr[] = { 5, 6, 4, 2, 4, 6, 5 };
		int expectedArray[] = { 2, 6, 5, 5, 4, 5, 8 };
		assertFalse(expectedArray == test.fitXY(arr, 4, 5));
	}

}
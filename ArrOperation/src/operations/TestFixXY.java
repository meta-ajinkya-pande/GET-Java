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
	public void test_NegativeElementsInArray() {
		int[] arr = { 1, -1, 2, 3 };
		boolean output = ArrOperation.checkArray(arr);
		assertEquals(false, output);
	}

	@Test
	public void test_When_NumberOf_X_And_Y_Equal_Expected_Array() {
		int arr[] = { 5, 6, 4, 2, 4, 6, 5 };
		int expectedArray[] = { 2, 6, 4, 5, 4, 5, 6 };
		try {
			assertArrayEquals(expectedArray, test.fitXY(arr, 4, 5));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_When_ArrayIsEmpty_Expected_AssertionErro() {
		try {
			int arr[] = {};
			int expectedArray[] = {};
			try {
				assertArrayEquals(expectedArray, test.fitXY(arr, 4, 5));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AssertionError e) {
			assertEquals("Array is empty", e.getMessage());
		}
	}

	@Test
	public void test_When_Adjacent_X_Values_Present() {
		try {
			int arr[] = { 1, 2, 4, 4, 2, 4, 2, 1, 4, 2 };
			int expectedArray[] = {};
			try {
				assertArrayEquals(expectedArray, test.fitXY(arr, 4, 2));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AssertionError e) {
			assertEquals("Adjacent X values present", e.getMessage());
		}
	}

	@Test
	public void test_When_X_At_Last_Position() {
		try {
			int arr[] = { 1, 2, 3 };
			int expectedArray[] = {};
			try {
				assertArrayEquals(expectedArray, test.fitXY(arr, 3, 2));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AssertionError e) {
			assertEquals("X is at last position", e.getMessage());
		}
	}

	@Test
	public void test_When_NumberOfX_And_Y_NotEqual_Expected_AssertionError() {
		try {
			int arr[] = { 6, 4, 2, 5, 1, 5, 9 };
			int expectedArray[] = {};
			try {
				assertArrayEquals(expectedArray, test.fitXY(arr, 5, 4));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AssertionError e) {
			assertEquals(
					"X and Y count not equal or count of X is less than Y",
					e.getMessage());
		}
	}

	@Test
	public void test_When_XIsAtLastPosition_Expected_AssertionErro() {
		try {
			int arr[] = { 6, 4, 2, 5, 1, 5, 4 };
			int expectedArray[] = {};
			try {
				assertArrayEquals(expectedArray, test.fitXY(arr, 4, 5));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void negativeTestForFixXY() {
		int arr[] = { 5, 6, 4, 2, 4, 6, 5 };
		int expectedArray[] = { 2, 6, 5, 5, 4, 5, 8 };
		try {
			assertFalse(expectedArray == test.fitXY(arr, 4, 5));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
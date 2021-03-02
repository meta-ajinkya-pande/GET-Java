package operations;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCountClumps {

	ArrOperation test;

	@Before
	public void init() {
		test = new ArrOperation();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_When_arrayHasOneElement() {
		int[] arr = { 1 };
		int output = test.noOfClumps(arr);
		assertEquals(0, output);
	}

	@Test
	public void test_When_SizeGreaterThanOne_Expected_Integer() {
		int arr[] = { 1, 1, 2, 2, 1, 1 };
		int output = test.noOfClumps(arr);
		assertEquals(3, output);
	}

	@Test
	public void test_When_AllElementsAreSame() {
		int arr[] = { 1, 1, 1, 1, 1 };
		int output = test.noOfClumps(arr);
		assertEquals(1, output);
	}

	@Test
	public void negativeTestCase() {
		int arr[] = { 1, 2, 3, 1, 1, 2 };
		int output = test.noOfClumps(arr);
		assertNotEquals(5, output);
	}

	@Test
	public void arrayIsEmpty_Expected_AssertionError() {
		try {
			int arr[] = {};
			int output = test.noOfClumps(arr);
			assertEquals(0, output);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

}
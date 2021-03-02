package operations;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLargestMirror {

	ArrOperation test;

	@Before
	public void init() {
		test = new ArrOperation();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_ArraySizeGreaterThanOne() {
		int arr[] = { 1, 2, 3, 4, 6, 3, 2, 1 };
		int output = test.largestMirror(arr);
		assertEquals(3, output);
	}

	@Test
	public void test_Palindrome_Array() {
		int arr[] = { 1, 2, 3, 4, 3, 2, 1 };
		int output = test.largestMirror(arr);
		assertEquals(7, output);
	}

	@Test
	public void test__ArrayHasSinlgeElement() {
		int arr[] = { 2 };
		int output = test.largestMirror(arr);
		assertEquals(1, output);
	}
}
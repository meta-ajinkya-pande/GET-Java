import java.util.HashMap;
import java.util.Scanner;

public class HexCalculator {
	private String n1, n2;
	// We can change the base for generic conversion
	private static int base = 16;
	public static HashMap<Character, Integer> value = new HashMap<Character, Integer>();

	// Add keys and values like (A, 10)
	public void initValue() {
		value.put('0', 0);
		value.put('1', 1);
		value.put('2', 2);
		value.put('3', 3);
		value.put('4', 4);
		value.put('5', 5);
		value.put('6', 6);
		value.put('7', 7);
		value.put('8', 8);
		value.put('9', 9);
		value.put('A', 10);
		value.put('B', 11);
		value.put('C', 12);
		value.put('D', 13);
		value.put('E', 14);
		value.put('F', 15);
		value.put('a', 10);
		value.put('b', 11);
		value.put('c', 12);
		value.put('d', 13);
		value.put('e', 14);
		value.put('f', 15);
	}

	HexCalculator(String n1, String n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	// output hex and decimal of it
	private void getNumber() {
		System.out.println("Input Hex Numbers: " + n1 + " " + n2);
		System.out.println("Decimal Values: " + HexCalculator.toDecimal(n1)
				+ " " + HexCalculator.toDecimal(n2));
	}

	// To convert hex to decimal
	public static int toDecimal(String s) {
		int num = 0, i, len = s.length();
		for (i = 0; i < len; i++) {
			num += value.get(s.charAt(i)) * Math.pow(base, len - i - 1);
		}
		return num;
	}

	// To convert decimal to hex
	private static String toHex(int n) {
		int rem;
		String hexStr = "";
		char hexValues[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		while (n > 0) {
			rem = n % 16;
			hexStr = hexValues[rem] + hexStr;
			n = n / 16;
		}
		return hexStr;
	}

	// arithmetic operations
	private String addNum() {
		return toHex((HexCalculator.toDecimal(n1) + HexCalculator.toDecimal(n2)));
	}

	private String subNum() {
		return toHex((HexCalculator.toDecimal(n1) - HexCalculator.toDecimal(n2)));
	}

	private String mulNum() {
		return toHex((HexCalculator.toDecimal(n1) * HexCalculator.toDecimal(n2)));
	}

	private String divNum() {
		return toHex((HexCalculator.toDecimal(n1) / HexCalculator.toDecimal(n2)));
	}

	// conditional operations
	private boolean checkEquals() {
		boolean res = false;
		int compare = n1.compareTo(n2);
		if (compare == 0) {
			res = true;
		}
		return res;
	}

	private boolean checkGreater() {
		boolean res = false;
		int compare = n1.compareTo(n2);
		if (compare > 0) {
			res = true;
		}
		return res;
	}

	private boolean checkSmaller() {
		boolean res = false;
		int compare = n1.compareTo(n2);
		if (compare < 0) {
			res = true;
		}
		return res;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String a, b;
		System.out.println("Enter two number: ");
		a = input.nextLine();
		b = input.nextLine();
		HexCalculator obj = new HexCalculator(a, b);
		obj.initValue();
		// get number
		obj.getNumber();
		// add
		System.out.println("\nSum is: " + obj.addNum());
		// subtract
		System.out.println("Subtraction is: " + obj.subNum());
		// multiply
		System.out.println("Multiply is: " + obj.mulNum());
		// delete
		System.out.println("Division is: " + obj.divNum());
		// check equals
		System.out.println("\nNumber 1 == Number 2: " + obj.checkEquals());
		// check greater
		System.out.println("Number 1 > Number 2: " + obj.checkGreater());
		// check smaller
		System.out.println("Number 1 < Number 2: " + obj.checkSmaller());
		// decimal to hex
		System.out.println("\nDecimal '171' to Hex: "
				+ HexCalculator.toHex(171));
		input.close();
	}
}

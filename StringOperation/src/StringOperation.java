import java.util.Scanner;

public class StringOperation {
	Scanner in = new Scanner(System.in);
	String str;

	// input string
	private StringOperation() {
		System.out.println("Enter String: ");
		str = in.nextLine();
	}

	// Display String
	private void displayString() {
		System.out.println(str);
	}

	/*Comparing two strings
	 * @param s1 is first string
	 * @param s2 is second string
	 * @return 1 for equal and 0 for not equal
	 */
	private static int strCompare(StringOperation s1, StringOperation s2) {
		int flag = 1;
		if (s1.str.length() != s2.str.length()) {
			flag = 0;
		} else {
			int len = s1.str.length();
			for (int i = 0; i < len; i++) {
				if (s1.str.charAt(i) != s2.str.charAt(i)) {
					flag = 0;
					break;
				}
			}
		}
		return flag;
	}

	// reverse string
	private void reverse() {
		System.out.println("\nReversed String: ");
		String s = "";
		int len = str.length();
		for (int i = len - 1; i >= 0; i--) {
			s += str.charAt(i);
		}
		str = s;
		
		displayString();
	}

	/*change case of a string
	 * @param str is operating string to change case
	 */
	private void changeCase(String str) {
		System.out.println("\nAfter changing case: ");
		String s = "";
		int len = str.length();
		for (int i = len - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				s += " ";
			} else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				s += (char) (str.charAt(i) + 32);
			} else {
				s += (char) (str.charAt(i) - 32);
			}
		}
		System.out.println(s);
	}

	// 
	/*send large word from a string
	 * @return largest word from string
	 */
	private String largeWord() {
		int index = 0, maxLength = 0, count = 1, i = 0;
		String maxWord = "";
		int lenStr = str.length();
		for (i = 0; i < lenStr - 1; i++) {
			if (str.charAt(i + 1) == ' ') {
				count = 0;
			} else {
				count++;
			}
			if (count >= maxLength) {
				maxLength = count;
				index = i - (count - 1) + 1;
			}
		}
		// generating word
		for (i = index; i < maxLength + index; i++) {
			maxWord += str.charAt(i);
		}
		return maxWord;
	}

	public static void main(String[] args) {
		StringOperation s1 = new StringOperation();
		s1.displayString();
		StringOperation s2 = new StringOperation();
		s2.displayString();
		// compare string
		if (StringOperation.strCompare(s1, s2) == 1) {
			System.out.println("\nBoth string are equal !");
		} else {
			System.out.println("\nBoth string are not equal !");
		}
		// get large word
		System.out.println("Largest word in \"" + s1.str + "\" is: "
				+ s1.largeWord());
		// reverse of s1
		s1.reverse();
		// change case
		s1.changeCase(s1.str);
	}
	
}

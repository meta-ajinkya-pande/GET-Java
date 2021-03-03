package lcm_hcf;
import java.util.Scanner;

public class LcmHcf {

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a == b)
			return a;

		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}

	static int lcm(int a, int b) {
		return (a / gcd(a, b)) * b;
	}

	public static void main(String[] args) {
		int a, b, lcm, hcf;
		Scanner in = new Scanner(System.in);
		System.out.println("Calculating LCM");
		System.out.println("Enter first number: ");
		a = in.nextInt();
		System.out.println("Enter second number: ");
		b = in.nextInt();
		lcm = lcm(a, b);
		System.out.println("LCM: " + lcm);

		System.out.println("Calculating HCF");
		System.out.println("Enter first number: ");
		a = in.nextInt();
		System.out.println("Enter second number: ");
		b = in.nextInt();
		hcf = gcd(a, b);
		System.out.println("HCF: " + hcf);

		in.close();
	}

}

package shopping;

import java.util.*;

/* Driver class
 * This class is used to select cart operation based on the use input.*/

public class ShoppingCart {
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {

		Storage store = new Storage();
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		String removeOption = "n";
		int id;

		while (!exit) {
			System.out.println("Enter code number: ");
			String choice = input.nextLine();
			if (choice.equals("VC") || choice.equals("vc")) {
				Cart.showCart();
				System.out.println("\nDo you want to remove any item ? (y/n)");
				removeOption = input.next();

				if (removeOption.equals("y") || removeOption.equals("Y")) {
					System.out.println("\nEnter code number to remove: ");
					id = input.nextInt();
					Cart.removeItem(id);
					;
				} else {

				}
			} else if (choice.equals("INV") || choice.equals("inv")) {
				System.out.print("\n");
				exit = true;
				Cart.printInvoice();
				System.out.println("\nThank you for shopping !");

			} else if (isNumeric(choice) && Integer.parseInt(choice) >= 1
					&& Integer.parseInt(choice) <= store.getStorageTotalItems()) {
				Cart.addItem(Storage.getItem(Integer.parseInt(choice)));
			} else {
				System.out.println("\nEnter valid option !");
			}
		}
	}

}

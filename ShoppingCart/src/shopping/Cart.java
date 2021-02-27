package shopping;

import java.util.ArrayList;

/* This class is used to perform operations on cart like:
 *  add
 *  remove
 *  show cart
 *  generate invoice*/
public class Cart {

	private static ArrayList<Item> cart = new ArrayList<Item>();
	private static double cartTotal;

	public static void addItem(Item item) {
		boolean newItem = true;
		for (Object i : cart) {
			if (item.itemName.equals(((Item) i).itemName)) {
				((Item) i).incQuantity();
				newItem = false;
			}
		}
		if (newItem == true) {
			item.incQuantity();
			cart.add(item);
		}
		System.out.print("Added " + item.itemName + " " + "$" + item.itemPrice
				+ "\n");
	}

	public static void removeItem(int id) {
		boolean found = true;
		Item item = cart.get(id - 1);
		for (Object i : cart) {
			if (item.itemName.equals(((Item) i).itemName)) {
				((Item) i).decQuantity();
				System.out.println(item.itemName
						+ " removed from your cart !\n");
				if (((Item) i).quantity == 0)
					cart.remove(i);
				found = true;
				break;
			} else {
				found = false;
			}
		}
		if (!found) {
			System.out.println("Item not found in your cart !\n");
		}
	}

	public static void printInvoice() {
		for (Object i : cart) {
			cartTotal += ((Item) i).itemPrice * ((Item) i).quantity;
		}
		System.out.println("Your total bill is : $" + cartTotal);

	}

	public static void showCart() {
		int count = 1;
		int c = 0;
		int size = cart.size();

		if (size < 1) {
			System.out.println("Cart is empty ! ");
		} else {
			System.out.println("\nYour Cart:");
			System.out.print("Code" + "\t" + "Item" + "\t\t" + "Quantity"
					+ "\t" + "Price\n");
			for (Object i : cart) {
				System.out.print(count + "\t" + ((Item) i).itemName + "\t"
						+ ((Item) i).quantity + "\t\t" + "$"
						+ ((Item) i).itemPrice + "\n");
				count++;
			}
		}
	}
}

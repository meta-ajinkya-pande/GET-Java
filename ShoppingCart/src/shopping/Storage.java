package shopping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* This class is used to add items to the storage unit.*/

public class Storage {
	// String s = "Bread Packet,30,0";
	// String[] z = s.split(",");
	// private Item bread = new Item(z[0], z, 0);
	private Item bread = new Item("Bread Packet", 30, 0);
	private Item butter = new Item("Amul  Butter", 40, 0);
	private Item cheese = new Item("Cheese  Pack", 50, 0);
	private Item cake = new Item("Fruit   Cake", 200, 0);
	private Item biscuit = new Item("Oreo Biscuit", 10, 0);
	private static ArrayList<Item> storage = new ArrayList<Item>();

	public Storage() {
		// storage.add(biscuit);
		// storage.add(bread);
		// storage.add(butter);
		// storage.add(cheese);
		// storage.add(cake);
		// reading StockItem.txt file for adding items in storage
		try {
			File myObj = new File(
					"D:\\GET\\ShoppingCart\\src\\shopping\\StockItem.txt");
			Scanner myReader = new Scanner(myObj);
			String data = "";
			while (myReader.hasNextLine()) {
				data += myReader.nextLine();
			}
			String[] dataItems = data.split(";");
			int lenDataItems = dataItems.length;
			for (int i = 0; i < lenDataItems; i++) {
				String[] item = dataItems[i].split(",");
				storage.add(new Item(item[0], Double.parseDouble(item[1]),
						Integer.parseInt(item[2])));
				// private Item x = new Item(item[0],
				// Double.parseDouble(item[1]),
				// Integer.parseInt(item[2]));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred. File not found !");
			e.printStackTrace();
		}
		printStore(storage);
	}

	public void printStore(ArrayList<Item> Store) {
		int c = 1;
		System.out.println("WELCOME TO OUR STORE\n");
		System.out.print("Code" + "\t" + "Item" + "\t\t" + "Price\n");
		for (Object i : Store) {
			System.out.println(c + "\t" + ((Item) i).itemName + "\t" + "$"
					+ ((Item) i).itemPrice);
			c++;
		}

		System.out.println("\nVC\tView Cart");
		System.out.println("INV\tGenerate Invoice");
	}

	public int getStorageTotalItems() {
		return storage.size();
	}

	public static Item getItem(int input) {
		return storage.get(input - 1);

	}

}

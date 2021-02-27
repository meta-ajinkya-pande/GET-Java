package shopping;

/* This class is used to define items.*/
public class Item {
	public String itemName;
	public double itemPrice;
	public int quantity;

	public Item(String name, double price, int quant) {
		itemName = name;
		itemPrice = price;
		quantity = quant;
	}

	public void incQuantity() {
		quantity++;
	}

	public void decQuantity() {
		quantity--;
	}

	public String getName() {
		return itemName;
	}

}

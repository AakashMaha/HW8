package HW8;

public class Inventory {
	public int SKU;
	public String title;
	public double price;
	public int quantity;
	public Inventory() {}
	public static String buildString(int sku, String title, double price, int quantity) {
		String output = "";
		output = sku + "                        " + title + "                         " + price + "                         " + quantity + "\n";
		return output;
	}
}

/**
 * Class describing a sale item and its relevant information.
 * For use in Budget Liquors Android application.
 */
public class SaleItem {
	
	String ItemName, ItemType, Price, Requirements, Notes;

	/**
	 * Default constructor creates an item with no information.
	 */
	public SaleItem() {
		// Default Constructor makes a new item with no information.
		this.ItemName = this.ItemType = this.Price = this.Requirements = this.Notes = "";
	}
	
	/**
	 * Constructor uses properly parsed strings from information file.
	 * @param information Parsed from the file found at "http://budgetapp.no-ip.biz/sales.txt"
	 */
	public SaleItem(String[] information) {
		this.ItemName = information[0];
		this.ItemType = information[1];
		this.Price = information[2];
		if(information.length>3)
		{
			this.Requirements = information[3];
		}
		else this.Requirements = "";
		if(information.length>4)
		{
			this.Notes = information[4];
		}
		else this.Notes = "";
	}
	
	/**
	 * Gets the name of an Item
	 * @return Name of item as a string.
	 */
	public String getItemName() {
		return ItemName;
	}

	/**
	 * Gets the type of an Item
	 * @return Type of item as a string.
	 */
	public String getItemType() {
		return ItemType;
	}

	/**
	 * Gets the price of an item.
	 * @return The price as a string.
	 */
	public String getPrice() {
		return Price;
	}

	/**
	 * Gets any special requirements to meet a Sale.
	 * @return The special requirements code as a string.
	 */
	public String getRequirements() {
		return Requirements;
	}

	/**
	 * Gets any notes the item may have.
	 * @return The notes as a string.
	 */
	public String getNotes() {
		return Notes;
	}
	
	/**
	 * Returns a formatted String for the Sale Item.
	 */
	public String toString() {
		String out = "";
		out += this.ItemName + " " + this.Price + "\n";
		out += this.ItemType;
		return out;
	}

	public static void main(String[] args) {
		String[] testparse = new String[]{"Bud Family/Coors Light/Miller Lite","24 Pack Longnecks","$14.99","N","Buy 5+"};
		SaleItem temp = new SaleItem(testparse);
		System.out.println(temp.ItemName);
		System.out.println(temp.ItemType);
		System.out.println(temp.Price);
		System.out.println(temp.Requirements);
		System.out.println(temp.Notes);
		System.out.println(temp.toString());
	}
}

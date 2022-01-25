package gameModel;


/**
 * Item class
 * 
 * This class defines an item in the game. 
 * Item class has a name,description and a location.
 * 
 * @author Irakli Bagratishvili
 */

public class Item {
	private String itemName;
	private String itemDesc;
	private Room itemLocation;
	
	public Item() {}
	public Item(String name) {
		this.itemName = name;

	}
	public void setitemName(String itemName) {
		this.itemName = itemName;
	}
	public String getitemName() {
		return itemName;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getitemDesc() {
		return itemDesc;
	}
	public void setItemLocation(Room itemLocation) {
		this.itemLocation = itemLocation;
	}
	public Room getItemLocation() {
		return itemLocation;
	}
	public String look() {
		return getitemDesc();
	}
	@Override
	public String toString() {
		 return "Thing name=" + itemName + ", desc=" + itemDesc +", item location" + itemLocation ;
		    }
}


package gameModel;
import java.util.*;

/**
 * Hero class
 * 
 * This class defines a playable character of the game. 
 * Hero has a currentLocation and inventory where the player keeps the items.
 * 
 * @author Irakli Bagratishvili
 */

public class Hero {
	private static Room currentLocation;
	private ArrayList<Item> inventory;

	public Hero() {  
	inventory = new ArrayList<Item>();
	currentLocation = null;
	}
	public void setCurrentLocation(Room room) {
		this.currentLocation = room;
		
	}
	public Room getcurrentLocation() {
		return currentLocation;
	
	}
	public void lookRoom(HashMap<String,Room> rooms) {
		rooms.get(currentLocation).getRoomDesc();
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public void take(Item item) {
		inventory.add(item);
	}
	public void drop(Item item) {
		inventory.remove(item);
	}
	public void use(Item item) {
		inventory.remove(item);
	}

	}





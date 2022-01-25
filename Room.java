package gameModel;

import java.util.*;

/**
 * Room class
 * 
 * This class defines a room/location/area in the game. 
 * Room has a name,description,items(reward,task items).
 * Also, the room can be locked until the reward item is received.
 * Finally, rooms are connected to each other through exists.
 * 
 * @author Irakli Bagratishvili
 */

public class Room {

    private String roomName;
    private String roomDesc;
    private Item roomItem;
    private Item taskItem;
    private Item rewardItem;
    private boolean locked;
    private HashMap<Paths, Room> exits;

    public Room(String name) {
        this.roomName = name;
        this.exits = new HashMap<Paths, Room>();
        this.taskItem = new Item();
        this.locked = false;
    }

    /**
     * @return the roomName
     */
    public String getRoomName() {
        return roomName;
    }
    /**
     * @return whether the next room is locked or not
     */
    public boolean isLocked() {
        return locked;
    }
    /**
     * @param takes boolean value locked as parameter
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * sets the name for the room.
     * @param takes roomName string as parameter
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * sets the description for the room. The function is used with look() to look around the room
     * @return the getRoomDesc
     */
    public String getRoomDesc() {
        return roomDesc;
    }
    /**
     * returns the reward item when the task is completed successfully.
     * @return the rewardItem
     */
    public Item getRewardItem() {
        return rewardItem;
    }
    /**
     * sets a reward item for a specific room, in order to be able to unlock the next room.
     * @param rewardItem
     */
    public void setRewardItem(Item rewardItem) {
        this.rewardItem = rewardItem;
    }

    /**
     * @param roomDesc the roomDesc to set
     */
    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    /**
     * @return the inventoryItems
     */
    public void setRoomItem(Item item) {
        this.roomItem = item;
    }
    /**
     * @return the roomName
     */
    public void setTaskItem(Item taskItem) {
        this.taskItem = taskItem;
    }
    /**
     * @return the roomName
     */
    public Item getTaskItem() {
        return taskItem;
    }
    /**
     * @return the roomItem
     */
    public Item getRoomItem() {
        return roomItem;
    }

    /**
     * Returns the exits of the room
     * @return the exits
     */
    public HashMap<Paths, Room> getExits() {
        return exits;
    }

    /**
     * //	 * @param exits the exits to set
     */
    public void setExit(Paths direction, Room neighbor) {
        this.exits.put(direction, neighbor);
    }
    /**
     * @return the roomName
     */
    public Room getExit(Paths direction) {
        return this.exits.get(direction);
    }


}

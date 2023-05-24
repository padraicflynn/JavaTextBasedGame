package engine;

import java.util.List;

import mansion.Mansion;
import mansion.Room;
import things.Inventory;
import things.Thing;

public class Player {
    private Room currentRoom;
    private Mansion mansion;
    private int lives = 3;
    private Inventory inventory = new Inventory();
    
    public Player(Mansion mansion) {
        this.mansion = mansion;
        this.currentRoom = mansion.getStartingRoom();
    }
    
    public Inventory getInventory() {
        return inventory;
    }

    
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addItem(Thing item) {
        inventory.add(item);
    }

    public void removeItem(Thing item) {
        inventory.remove(item);
    }

    public boolean hasItem(String itemName) {
        return inventory.contains(itemName);
    }

    public boolean hasItem(Thing item) {
        return inventory.contains(item.getName());
    }

    public List<Thing> getItems() {
        return inventory.getVisibleContents();
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }

    public boolean hasWon() {
        return currentRoom.getName().equals("exit");
    }

    public void displayInventory() {
        inventory.displayVisibleInventory();
    }

    public void inspectItem(String itemName) {
        Thing item = inventory.getVisible(itemName);
        if (item == null) {
            System.out.println("You don't have that item.");
        } else {
            System.out.println(item.getDescription());
        }
    }

    public void useItem(String itemName) {
        Room currentRoom = getCurrentRoom();
        List<Thing> items = getItems();
        boolean used = false;
        Thing item = null;

        for (Thing thing : items) {
            if (thing.getName().equals(itemName)) {
                item = thing;
                break;
            }
        }

        if (item != null) {
            if (item.isItem()) {
                // Check if the item can be used in the current room
                if (currentRoom.canUseItem(this, item)) {
                    currentRoom.useItem(this, itemName);
                    removeItem(item);
                    System.out.println("You have used the " + item.getName() + ".");
                    used = true;
                } else {
                    System.out.println("You cannot use the " + item.getName() + " in this room.");
                }
            } else {
                System.out.println("You cannot use the " + item.getName() + " as it is not an item.");
            }
        } else {
            System.out.println("You don't have the " + itemName + " in your inventory.");
        }
    }


    public Mansion getMansion() {
        return mansion;
    }
}

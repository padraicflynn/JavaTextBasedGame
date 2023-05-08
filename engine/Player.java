package engine;

import java.util.ArrayList;
import java.util.List;

import mansion.Mansion;
import mansion.Room;
import things.Inventory;
import things.Thing;

public class Player {
	private Room currentRoom;
	 private Mansion mansion;

	 public Player(Mansion mansion) {
	        this.mansion = mansion;
	        this.currentRoom = mansion.getStartingRoom();
	    }
	 
    private int lives = 3;
    private Inventory inventory = new Inventory();
    
    private List<Thing> items;
    private String name;
    
    public Player() {
        this.lives = 3;
        this.items = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addItem(Thing item) {
        items.add(item);
    }

    public void removeItem(Thing item) {
        items.remove(item);
    }

    public boolean hasItem(String itemName) {
        for (Thing item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public List<Thing> getItems() {
        return items;
    }
 

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }

    public boolean hasItem(Thing item) {
        return inventory.contains(item.getName());
    }

   
    
    public boolean hasWon() {
        return currentRoom.getName().equals("exit");
    }
    
    public void displayInventory() {
        List<Thing> contents = inventory.getContents();
        if (contents.isEmpty()) {
            System.out.println("You are not carrying anything.");
        } else {
            System.out.println("You are carrying:");
            for (Thing item : contents) {
                System.out.println("- " + item.getName());
            }
        }
    }
    
    public void inspectItem(String itemName) {
        Thing item = inventory.get(itemName);
        if (item == null) {
            System.out.println("You don't have that item.");
        } else {
            System.out.println(item.getDescription());
        }
    }

    
    public void useItem(String itemName) {
        Room currentRoom = getCurrentRoom();
        Thing item = inventory.get(itemName);
        if (item == null) {
            System.out.println("You don't have that item.");
        } else if (!item.isItem()) {
            System.out.println("You can't use that.");
        } else if (currentRoom.canUseItem(this, item)) {
            currentRoom.useItem(this, item);
            inventory.remove(item);
        } else {
            System.out.println("You can't use that here.");
        }
    }
    
    public Mansion getMansion() {
        return mansion;
    }
    
}
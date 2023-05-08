package things;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Thing> items; // list of items in the inventory
    
    // constructor
    public Inventory() {
        items = new ArrayList<Thing>();
    }
    
    // add an item to the inventory
    public void add(Thing item) {
        items.add(item);
    }
    
    // remove an item from the inventory
    public void remove(Thing item) {
        items.remove(item);
    }
    
    // check if the inventory contains a specific item
    public boolean contains(String itemName) {
        for (Thing item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
    
    // get a list of all items in the inventory
    public List<Thing> getContents() {
        return items;
    }
    
    // get an item with a specific name from the inventory
    public Thing get(String itemName) {
        for (Thing item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    // display all items in the inventory
    public void displayInventory() {
        List<Thing> contents = getContents();
        if (contents.isEmpty()) {
            System.out.println("You are not carrying anything.");
        } else {
            System.out.println("You are carrying:");
            for (Thing item : contents) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
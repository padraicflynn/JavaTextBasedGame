package things;

import engine.Player;
import mansion.Room;

public class Thing {
    private String name;
    private String description;
    private boolean isItem;
    private boolean isUsable;

    public Thing(String name, String description, boolean isItem, boolean isUsable) {
        this.name = name;
        this.description = description;
        this.isItem = isItem;
        this.isUsable = isUsable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isItem() {
        return isItem;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void use(Player player, Room currentRoom) {
        // By default, nothing happens when the player uses the item
        System.out.println("You can't use the " + name + " here.");
    }

    public boolean canUseItem(Player player, String itemName, Room currentRoom) {
        // Find the Thing object corresponding to the provided itemName
        Thing thing = null;
        for (Thing t : currentRoom.getThings()) {
            if (t.getName().equals(itemName)) {
                thing = t;
                break;
            }
        }

        if (thing == null || !thing.isUsable()) {
            return false;
        }

        // Check if the player has the item in their inventory
        return player.hasItem(thing);
    }

    public void useItem(Player player, String itemName, Room currentRoom) {
        // Use the item in the room
        for (Thing thing : currentRoom.getThings()) {
            if (thing.getName().equals(itemName) && thing.isUsable()) {
                thing.use(player, currentRoom);
                return;
            }
        }
    }
}
package things;

import engine.Player;
import mansion.Room;

public class Thing {
    private String name;
    private String description;
    private boolean isItem;
    private boolean isUsable;
    private boolean isInvisible;

    public Thing(String name, String description, boolean isItem, boolean isUsable, boolean isInvisible) {
        this.name = name;
        this.description = description;
        this.isItem = isItem;
        this.isUsable = isUsable;
        this.isInvisible = isInvisible;
    }

    public boolean isInvisible() {
        return isInvisible;
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

    public boolean canUseItem(Player player, String itemName, Room currentRoom) {
        Thing item = player.getInventory().getVisible(itemName);

        if (item == null || !item.isUsable()) {
            return false;
        }

        return player.hasItem(itemName) && currentRoom.canUseItem(player, item);
    }

    
    public void useItem(Player player, Room currentRoom) {
        // Use the visible item in the room
        for (Thing thing : currentRoom.getVisibleThings()) {
            if (thing.getName().equals(name) && !thing.isInvisible() && thing.isUsable()) {
                // Special behavior for the haunted book
                if (name.equals("haunted book")) {
                    System.out.println("You open the haunted book, and a chilling presence surrounds you.");
                    System.out.println("The book drains your life force, and you lose one life.");
                    player.loseLife();
                    return;
                }

                // Default behavior for other usable items
                thing.use(player, currentRoom); // Call the use method on the specific Thing object
                return;
            }
        }
        System.out.println("You can't use that here.");
    }

    // Define the use method
    public void use(Player player, Room currentRoom) {
        // Implement the desired behavior when the Thing is used
        // This method can be overridden in subclasses to provide specific behavior for each Thing
        System.out.println("You use the " + name + ".");
    }
}

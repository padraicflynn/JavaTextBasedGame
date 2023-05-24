package mansion;

import engine.Player;
import things.Thing;

import java.util.ArrayList;
import java.util.List;

public class EntranceWay implements Room {
    private final String name;
    private final String description;
    private final List<Thing> things;
    private final List<Exit> exits;
    private Player player;

    public EntranceWay() {
        this.name = "Entrance Way";
        this.description = "You are standing in the entrance way of the mansion. There is a living room beyond a large archway to the north, and a dining room to the east.";
        this.things = new ArrayList<>();
        this.exits = new ArrayList<>();
        this.player = null;

        // Add a key to the room
        Thing key = new Thing("key", "A small, rusty key", true, true, false);
        things.add(key);

        // Add the haunted book as a visible item in the room
        Thing hauntedBook = new Thing("haunted book", "A mysterious book emanating an eerie aura", true, true, false);
        things.add(hauntedBook);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Thing> getVisibleThings() {
        List<Thing> visibleThings = new ArrayList<>();
        for (Thing thing : things) {
            if (!thing.isInvisible()) {
                visibleThings.add(thing);
            }
        }
        return visibleThings;
    }

    @Override
    public List<Exit> getExits() {
        return exits;
    }

    @Override
    public boolean canUseItem(Player player, Thing item) {
        // Add specific conditions for other items if needed
        return true; // Default behavior for other items
    }

    @Override
    public void useItem(Player player, String itemName) {
        // Define the behavior for the haunted book
        if (itemName.equals("haunted book")) {
            System.out.println("You open the haunted book, and a chilling presence surrounds you.");
            System.out.println("The book drains your life force, and you lose three life.");
            player.loseLife();
            player.loseLife();
            player.loseLife();
        }
    }

    @Override
    public void enter(Player player) {
        this.player = player;
        System.out.println("You have entered the " + name + ".");
        System.out.println(description);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void exit(Player player, Exit exit) {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom == this && exits.contains(exit)) {
            player.setCurrentRoom(exit.getTargetRoom());
            System.out.println("You have exited the " + name + ".");
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    @Override
    public void addExit(Exit exit) {
        exits.add(exit);
    }

	 

 
}

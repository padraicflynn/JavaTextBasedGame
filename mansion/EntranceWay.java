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
        this.description = "You are standing in the entrance way of the mansion. There is a living room beyond a large arch way to the north, and a dining room to the east.";
        this.things = new ArrayList<>();
        this.exits = new ArrayList<>();
        this.player = null;

        // Add a key to the table
        Thing key = new Thing("key", "A small, rusty key", true, true);
        things.add(key);
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
    public List<Thing> getThings() {
        return things;
    }

    @Override
    public List<Exit> getExits() {
        return exits;
    }

    @Override
    public boolean canUseItem(Player player, Thing item) {
        return false; // No items can be used in this room
    }

    @Override
    public void useItem(Player player, Thing item) {
        // Do nothing, since no items can be used in this room
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
            player.setCurrentRoom(exit.getDestination());
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

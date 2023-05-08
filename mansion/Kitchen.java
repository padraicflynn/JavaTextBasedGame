package mansion;

import java.util.ArrayList;
import java.util.List;

import engine.Player;
import things.Thing;

public class Kitchen implements Room {

    private final String name;
    private final String description;
    private final List<Thing> things;
    private final List<Exit> exits;

    public Kitchen() {
        name = "Kitchen";
        description = "A spacious kitchen with gleaming countertops and modern appliances.";
        things = new ArrayList<>();
        exits = new ArrayList<>();
        
        // Add things to the room
        things.add(new Thing("knife", "A sharp kitchen knife.", true, true));

        // Add exits
        exits.add(new Exit("south", new DiningRoom()));
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
        return false;
    }

    @Override
    public void useItem(Player player, Thing item) {
        // Do nothing
    }

    @Override
    public void enter(Player player) {
        player.setCurrentRoom(this);
        System.out.println("You have entered the " + name + ".");
        System.out.println(description);
    }

    @Override
    public void exit(Player player, Exit exit) {
        System.out.println("You have left the " + name + ".");
        exit.getTargetRoom().enter(player);
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public void addExit(Exit exit) {
        exits.add(exit);
    }

}

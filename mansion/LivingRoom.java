package mansion;

import engine.Player;
import things.Thing;

import java.util.ArrayList;
import java.util.List;

public class LivingRoom implements Room {

    private final String name;
    private final String description;
    private final List<Thing> things;
    private final List<Exit> exits;

    public LivingRoom() {
        name = "Living Room";
        description = "You are in a spacious living room with a comfortable couch, a TV, and a fireplace.";
        things = new ArrayList<>();
        exits = new ArrayList<>();

        // Add things to the room
        things.add(new Thing("TV", "A large flat screen TV.", true, false));
        things.add(new Thing("Couch", "A cozy-looking couch.", false, false));
        things.add(new Thing("Fireplace", "A grand fireplace with a roaring fire.", false, false));
        things.add(new Thing("Painting", "A beautiful painting hanging on the wall.", false, false));

        // Add exits
        exits.add(new Exit("north", new Kitchen()));
        exits.add(new Exit("east", new DiningRoom()));
        exits.add(new Exit("west", new EntranceWay()));
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
        // Do nothing
    }
}

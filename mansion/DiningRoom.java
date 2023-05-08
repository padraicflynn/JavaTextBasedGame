package mansion;

import engine.Player;
import things.Thing;

import java.util.ArrayList;
import java.util.List;

public class DiningRoom implements Room {

    private String name;
    private String description;
    private List<Thing> things;
    private List<Exit> exits;
    private Player player;

    public DiningRoom() {
        name = "Dining Room";
        description = "A large dining room with an ornate table and chairs.";
        things = new ArrayList<>();
        exits = new ArrayList<>();
        things.add(new Thing("candlestick", "A heavy brass candlestick.", true, true));
        things.add(new Thing("wine bottle", "An expensive-looking bottle of red wine.", true, true));
     //   exits.add(new Exit("north", new Kitchen()));
     //   exits.add(new Exit("west", new LivingRoom()));
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
        this.player = player;
        System.out.println("You have entered the " + name + ".");
    }

    @Override
    public void exit(Player player, Exit exit) {
        this.player = null;
        System.out.println("You have left the " + name + ".");
    }
    

    @Override
    public Player getPlayer() {
        return player;
    }

	@Override
	public void addExit(Exit exit) {
		// TODO Auto-generated method stub
		
	}

	 

	 

	 
}

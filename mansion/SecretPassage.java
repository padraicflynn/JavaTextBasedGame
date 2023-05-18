package mansion;

import engine.Player;
import things.Thing;

import java.util.ArrayList;
import java.util.List;

public class SecretPassage implements Room {
    private final String name;
    private final String description;
    private final List<Thing> things;
    private final List<Exit> exits;
    private Player player;

    public SecretPassage() {
        this.name = "Secret Passage";
        this.description = "You find yourself in a hidden passage with dimly lit torches along the walls.";
        this.things = new ArrayList<>();
        this.exits = new ArrayList<>();
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
        // Implement the logic to determine if the item can be used in the secret passage
        return false;
    }

    @Override
    public void useItem(Player player, Thing item) {
        // Implement the logic to use the item in the secret passage
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

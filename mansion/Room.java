package mansion;

import engine.Player;

import things.Thing;

import java.util.List;

public interface Room {
	
	
	
	/**
     * Returns the name of the room.
     */
    String getName();

    /**
     * Returns the description of the room.
     */
    String getDescription();

    /**
     * Returns the list of things in the room.
     */
    List<Thing> getThings();

    /**
     * Returns the list of exits from the room.
     */
    List<Exit> getExits();

    /**
     * Returns whether the given player can use the given item in the room.
     */
    boolean canUseItem(Player player, Thing item);

    /**
     * Uses the given item in the room with the given player.
     */
    void useItem(Player player, Thing item);

    /**
     * Enters the room with the given player.
     */
    void enter(Player player);

    /**
     * Returns the player currently in the room.
     */
    Player getPlayer();

    /**
     * Exits the room using the given exit with the given player.
     */
    void exit(Player player, Exit exit);

    /**
     * Adds the given exit to the room.
     */
    void addExit(Exit exit);
}
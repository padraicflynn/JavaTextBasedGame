package mansion;

import engine.Player;

import things.Thing;

import java.util.List;

public interface Room {
	
	
	
	 
    String getName();
 
    String getDescription();
 
    List<Thing> getThings();
 
    List<Exit> getExits();
 
    boolean canUseItem(Player player, Thing item);
 
    void useItem(Player player, Thing item);
 
    void enter(Player player);
 
    Player getPlayer();
 
    void exit(Player player, Exit exit);
 
    void addExit(Exit exit);
}
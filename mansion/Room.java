package mansion;

import engine.Player;
import things.Thing;

import java.util.List;

public interface Room {
    String getName();

    String getDescription();

    List<Thing> getVisibleThings();

    List<Exit> getExits();

    default boolean canUseItem(Player player, Thing item) {
        return true; // Allow the usage of any item in any room
    }

    void useItem(Player player, String itemName);

    void enter(Player player);

    Player getPlayer();

    void exit(Player player, Exit exit);

    void addExit(Exit exit);
}

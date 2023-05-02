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

    void exit(Player player, Exit exit);

    Player getPlayer();

    class Exit {
        private String direction;
        private Room targetRoom;

        public Exit(String direction, Room targetRoom) {
            this.direction = direction;
            this.targetRoom = targetRoom;
        }

        public String getDirection() {
            return direction;
        }

        public Room getTargetRoom() {
            return targetRoom;
        }
    }

}
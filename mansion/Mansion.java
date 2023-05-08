package mansion;

import java.util.HashMap;
import java.util.Map;

public class Mansion {
    private final Map<String, Room> rooms;

    public Mansion() {
        this.rooms = new HashMap<>();

        // create all rooms and add them to the map
        Room entranceWay = new EntranceWay();
        Room livingRoom = new LivingRoom();
        Room diningRoom = new DiningRoom();
        Room kitchen = new Kitchen();
        Room study = new Study();
        Room bedroom = new Bedroom();
        Room conservatory = new Conservatory();
        Room library = new Library();
        Room billiardRoom = new BilliardRoom();
        Room cellar = new Cellar();
        Room secretPassage1 = new SecretPassage();
        Room secretPassage2 = new SecretPassage();

        // add exits to each room
        entranceWay.addExit(new Exit("north", livingRoom));
        entranceWay.addExit(new Exit("east", diningRoom));
        entranceWay.addExit(new Exit("south", conservatory));

        livingRoom.addExit(new Exit("south", entranceWay));
        livingRoom.addExit(new Exit("east", diningRoom));
        livingRoom.addExit(new Exit("west", kitchen));
        livingRoom.addExit(new Exit("up", study));

        diningRoom.addExit(new Exit("west", livingRoom));
        diningRoom.addExit(new Exit("north", entranceWay));
        diningRoom.addExit(new Exit("east", billiardRoom));

        kitchen.addExit(new Exit("east", livingRoom));
        kitchen.addExit(new Exit("north", study));
        kitchen.addExit(new Exit("down", cellar));

        study.addExit(new Exit("down", livingRoom));
        study.addExit(new Exit("east", bedroom));
        study.addExit(new Exit("south", kitchen));
        study.addExit(new Exit("north", library));

        bedroom.addExit(new Exit("west", study));
        bedroom.addExit(new Exit("north", billiardRoom));

        conservatory.addExit(new Exit("north", entranceWay));

        library.addExit(new Exit("south", study));

        billiardRoom.addExit(new Exit("south", bedroom));
        billiardRoom.addExit(new Exit("west", diningRoom));
        billiardRoom.addExit(new Exit("north", secretPassage1));

        cellar.addExit(new Exit("up", kitchen));
        
        secretPassage1.addExit(new Exit("south", billiardRoom));
        secretPassage1.addExit(new Exit("east", secretPassage2));

        secretPassage2.addExit(new Exit("west", secretPassage1));
        
        rooms.put("entranceWay", entranceWay);
        rooms.put("livingRoom", livingRoom);
        rooms.put("diningRoom", diningRoom);
        rooms.put("kitchen", kitchen);
        rooms.put("study", study);
        rooms.put("bedroom", bedroom);
        rooms.put("conservatory", conservatory);
        rooms.put("library", library);
        rooms.put("billiardRoom", billiardRoom);
        rooms.put("cellar", cellar);
        rooms.put("secretPassage1", secretPassage1);
        rooms.put("secretPassage2", secretPassage2);
    }

    public Room getStartingRoom() {
        return rooms.get("entranceWay");
    }

    public void addRoom(Room room) {
        rooms.put(room.getName().toLowerCase().replace(" ", ""), room);
    }
}

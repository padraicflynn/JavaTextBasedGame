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
        Room secondFloorHall = new SecondFloorHall();
        Room masterBedroom = new MasterBedroom();
        Room masterBathroom = new MasterBathroom();
        Room firstFloorBathroom = new Bathroom();
        Room firstFloorHallway = new FirstFloorHallway();
        Room guestRoom = new GuestRoom();

        // add exits to each room
        entranceWay.addExit(new Exit("north", firstFloorHallway));
        entranceWay.addExit(new Exit("east", diningRoom));
        entranceWay.addExit(new Exit("west", conservatory));
        entranceWay.addExit(new Exit("up", secondFloorHall));

        livingRoom.addExit(new Exit("south", entranceWay));
        livingRoom.addExit(new Exit("east", diningRoom));
        livingRoom.addExit(new Exit("west", billiardRoom));
     
        diningRoom.addExit(new Exit("west", entranceWay));
        diningRoom.addExit(new Exit("north", kitchen));
      
        kitchen.addExit(new Exit("west", firstFloorHallway));
        kitchen.addExit(new Exit("down", cellar));
        
 
        study.addExit(new Exit("east", secondFloorHall));
        study.addExit(new Exit("north", library));

        bedroom.addExit(new Exit("west", secondFloorHall));
   
        conservatory.addExit(new Exit("east", entranceWay));

        library.addExit(new Exit("south", study));
 
        billiardRoom.addExit(new Exit("west", livingRoom));
    
        cellar.addExit(new Exit("up", kitchen));

        secondFloorHall.addExit(new Exit("south", masterBedroom));
        secondFloorHall.addExit(new Exit("east", bedroom));
        secondFloorHall.addExit(new Exit("down", entranceWay));
        secondFloorHall.addExit(new Exit("west", study));
        secondFloorHall.addExit(new Exit("north", guestRoom));
        
        guestRoom.addExit(new Exit ("south", secondFloorHall));

        masterBedroom.addExit(new Exit("north", secondFloorHall));
        masterBedroom.addExit(new Exit("south", masterBathroom));

        masterBathroom.addExit(new Exit("north", masterBedroom));

        firstFloorBathroom.addExit(new Exit("south", firstFloorHallway));
        
      firstFloorHallway.addExit(new Exit ("south", entranceWay));
      firstFloorHallway.addExit(new Exit("north", firstFloorBathroom));
      firstFloorHallway.addExit(new Exit("west", livingRoom));
      firstFloorHallway.addExit(new Exit("east", kitchen));
      
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
        rooms.put("secondFloorHall", secondFloorHall);
        rooms.put("masterBathroom", masterBathroom);
        rooms.put("firstFloorBathroom", firstFloorBathroom);
        rooms.put("FirstFloorHallway", firstFloorHallway);
    }

    public Room getStartingRoom() {
        return rooms.get("entranceWay");
    }

    public void addRoom(Room room) {
        rooms.put(room.getName().toLowerCase().replace(" ", ""), room);
    }
}
        
        

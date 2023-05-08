package mansion;

public class Exit {
    private String direction;
    private Room destination;

    public Exit(String direction, Room destination) {
    	 this.direction = direction.toLowerCase().replace(" ", "");
        this.destination = destination;
    }

    public String getDirection() {
        return direction;
    }

    public Room getDestination() {
        return destination;
    }

    public Room getTargetRoom() {
        return destination;
    }
}

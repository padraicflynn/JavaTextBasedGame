package engine;

import java.util.List;
import java.util.Scanner;
import mansion.Room;
import things.Thing;
import java.util.stream.*;
 
public class Game {
	 private Player player;
	  public static void main(String[] args) {
	        Game game = new Game();
	        game.startGame();
	    }
	
	
	  public void startGame() {
		    Scanner scanner = new Scanner(System.in);
		     
		    Parser parser = new Parser();
		    player = new Player();

		    System.out.println("Welcome to the Mansion Adventure Game!");
		    System.out.println("You have three lives. Good luck!");

		    while (isRunning()) {
		        System.out.println();
		        System.out.print("> ");
		        String input = scanner.nextLine();
		        Command command = parser.parse(input); // parse input into a Command object
		        executeCommand(command); // pass the Command object to executeCommand()
		    }

		    System.out.println("Game over.");
		}


	
	public boolean isRunning() {
	    return player.getLives() > 0 && !player.hasWon();
	}
	
	public void executeCommand(Command command) {
	    switch (command.getCommandType()) {
	        case HELP:
	            displayHelp();
	            break;
	        case GO:
	            movePlayer(command.getArgument());
	            break;
	        case TAKE:
	            takeItem(command.getArgument());
	            break;
	        case USE:
	            useItem(command.getArgument());
	            break;
	        case INSPECT:
	            inspectItem(command.getArgument());
	            break;
	        case INVENTORY:
	            displayInventory();
	            break;
	        case QUIT:
	            quitGame();
	            break;
	        default:
	            System.out.println("Invalid command. Type 'help' for a list of commands.");
	            break;
	    }
	    
	}
	public void displayHelp() {
	    System.out.println("List of available commands:");
	    System.out.println("help - display list of commands");
	    System.out.println("go <direction> - move player in the specified direction");
	    System.out.println("take <item> - add item to player's inventory");
	    System.out.println("use <item> - use item in player's inventory");
	    System.out.println("inspect <item> - examine an item in the room or player's inventory");
	    System.out.println("inventory - display contents of player's inventory");
	    System.out.println("quit - exit the game");
	}

	public void movePlayer(String direction) {
	    List<Room.Exit> exits = player.getCurrentRoom().getExits();
	    for (Room.Exit exit : exits) {
	        if (exit.getDirection().equalsIgnoreCase(direction)) {
	            Room targetRoom = exit.getTargetRoom();
	            player.getCurrentRoom().exit(player, exit);
	            targetRoom.enter(player);
	            return;
	        }
	    }
	    System.out.println("There is no exit in that direction.");
	}


	public void takeItem(String itemName) {
	    Room currentRoom = player.getCurrentRoom();
	    List<Thing> things = currentRoom.getThings();
	    Thing item = null;

	    for (Thing thing : things) {
	        if (thing.getName().equals(itemName)) {
	            item = thing;
	            break;
	        }
	    }

	    if (item != null) {
	        player.addItem(item);
	        currentRoom.getThings().remove(item);
	        System.out.println("You have taken the " + itemName + ".");
	    } else {
	        System.out.println("There is no " + itemName + " in this room.");
	    }
	}



	public void useItem(String itemName) {
	    Room currentRoom = player.getCurrentRoom();
	    List<Thing> items = player.getItems();
	    boolean used = false;

	    for (Thing item : items) {
	        if (item.getName().equals(itemName)) {

	            if (item.isItem()) {
	                // check if the item can be used in the current room
	                if (currentRoom.canUseItem(player, item)) {
	                    currentRoom.useItem(player, item);
	                    player.removeItem(item);
	                    System.out.println("You have used the " + item.getName() + ".");
	                    used = true;
	                    break;
	                } else {
	                    System.out.println("You cannot use the " + item.getName() + " in this room.");
	                }
	            } else {
	                System.out.println("You cannot use the " + item.getName() + " as it is not an item.");
	            }
	        }
	    }

	    if (!used) {
	        System.out.println("You don't have the " + itemName + " in your inventory.");
	    }
	}






	public void inspectItem(String itemName) {
	    List<Thing> items = player.getItems();
	    boolean found = false;
	    for (Thing item : items) {
	    	if (item.getName().equals(itemName)) {

	            System.out.println(item.getDescription());
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("You don't have that.");
	    }
	}


	public void displayInventory() {
	    List<Thing> items = player.getItems();
	    if (items.isEmpty()) {
	        System.out.println("Your inventory is empty.");
	    } else {
	        System.out.println("You are carrying:");
	        for (Thing item : items) {
	            System.out.println("- " + item.getName());
	        }
	    }
	}


	public void quitGame() {
	    System.out.println("Thanks for playing!");
	    System.exit(0);
	}

}
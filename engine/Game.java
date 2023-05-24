package engine;

import java.util.List;
import java.util.Scanner;
import mansion.*;
import things.Thing;

public class Game {
    private Player player;

    public static void main(String[] args) {
        Mansion mansion = new Mansion();
        Player player = new Player(mansion);

        Game game = new Game();
        game.player = player;
        game.startGame();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        try {
            Parser parser = new Parser();
            Room startingRoom = player.getMansion().getStartingRoom();
            player.setCurrentRoom(startingRoom);

            System.out.println("Welcome, type 'help' for the controls!");
            System.out.println("You are in the " + startingRoom.getName() + ", " + startingRoom.getDescription());

            while (isRunning()) {
                System.out.println();
                System.out.print("> ");
                String input = scanner.nextLine();
                Command command = parser.parse(input);
                executeCommand(command);
            }
            System.out.println("Game over.");
        } finally {
            scanner.close();
        }
    }

    public boolean isRunning() {
        return player.getLives() > 0 && !player.hasWon();
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

    public void executeCommand(Command command) {
        if (command.getCommandType() == null) {
            System.out.println("Invalid command. Type 'help' for a list of commands.");
            return;
        }

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
            case SEE:
                seeExits();
                break;
            default:
                System.out.println("Invalid command. Type 'help' for a list of commands.");
                break;
        }
    }

    public void movePlayer(String direction) {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom == null) {
            System.out.println("Error: current room is null.");
            return;
        }

        List<Exit> exits = currentRoom.getExits();
        if (exits == null) {
            System.out.println("Error: exits is null.");
            System.out.println("Current room: " + currentRoom.getName());
            System.out.println("Available exits: " + getExits());
            return;
        }

        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                Room targetRoom = exit.getTargetRoom();
                currentRoom.exit(player, exit);
                targetRoom.enter(player);
                return;
            }
        }
        System.out.println("There is no exit in that direction.");
    }

    public String getExits() {
        Room currentRoom = player.getCurrentRoom();
        List<Exit> exits = currentRoom.getExits();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exits.size(); i++) {
            sb.append(exits.get(i).getDirection());
            if (i != exits.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void takeItem(String itemName) {
        Room currentRoom = player.getCurrentRoom();
        List<Thing> visibleThings = currentRoom.getVisibleThings();
        Thing item = null;

        for (Thing thing : visibleThings) {
            if (matchesItemName(thing, itemName)) {
                item = thing;
                break;
            }
        }

        if (item == null) {
            // Handle item names with spaces
            String[] words = itemName.split("\\s+");
            for (Thing thing : visibleThings) {
                if (matchesItemName(thing, words)) {
                    item = thing;
                    break;
                }
            }
        }

        if (item != null) {
            player.addItem(item);
            visibleThings.remove(item);
            System.out.println("You have taken the " + item.getName() + ".");
        } else {
            System.out.println("There is no visible item named " + itemName + " in this room.");
        }
    }

    private boolean matchesItemName(Thing thing, String itemName) {
        String[] thingNameWords = thing.getName().split("\\s+");
        String[] itemWords = itemName.split("\\s+");

        // Check if the item name matches all words in the thing name
        for (String itemWord : itemWords) {
            boolean wordMatched = false;
            for (String thingWord : thingNameWords) {
                if (thingWord.equalsIgnoreCase(itemWord)) {
                    wordMatched = true;
                    break;
                }
            }
            if (!wordMatched) {
                return false;
            }
        }
        
        // Ensure the thing is an item and not invisible
        return thing.isItem() && !thing.isInvisible();
    }

    private boolean matchesItemName(Thing thing, String[] words) {
        for (String word : words) {
            if (matchesItemName(thing, word)) {
                return true;
            }
        }
        return false;
    }




    public void useItem(String itemName) {
        Room currentRoom = player.getCurrentRoom();
        List<Thing> items = player.getItems();
        boolean used = false;
        Thing item = null;

        for (Thing thing : items) {
            if (thing.getName().equalsIgnoreCase(itemName)) {
                item = thing;
                break;
            }
        }

        if (item == null) {
            // Check if the item name matches an item with spaces
            for (Thing thing : items) {
                if (thing.getName().toLowerCase().replaceAll("\\s+", "").startsWith(itemName.toLowerCase().replaceAll("\\s+", ""))) {
                    item = thing;
                    break;
                }
            }
        }

        if (item != null) {
            currentRoom.useItem(player, itemName);
        } else {
            System.out.println("You don't have the " + itemName + " in your inventory.");
        }
    }


    public void inspectItem(String itemName) {
        List<Thing> items = player.getItems();
        boolean found = false;

        for (Thing item : items) {
            if (item.getName().equalsIgnoreCase(itemName) || item.getName().toLowerCase().contains(itemName.toLowerCase())) {
                System.out.println(item.getDescription());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("You don't have that item.");
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

    public void seeExits() {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom == null) {
            System.out.println("Error: current room is null.");
            return;
        }

        System.out.println("Available exits: " + getExits());
    }
}

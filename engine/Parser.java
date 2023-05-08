package engine;

public class Parser {

	public Command parse(String input) {
	    String[] words = input.split(" ");
	    CommandType commandType = CommandType.getCommandType(words[0]);
	    String argument = null;
	    if (words.length > 1) {
	        argument = words[1];
	    }
	    return new Command(commandType, argument);
	}

	
}
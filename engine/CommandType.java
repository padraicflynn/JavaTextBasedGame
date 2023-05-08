package engine;

public enum CommandType {
    HELP("help"),
    GO("go"),
    TAKE("take"),
    USE("use"),
    INSPECT("inspect"),
    INVENTORY("inventory"),
    QUIT("quit"),
	SEE("see");

    private final String commandString;

    CommandType(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }

    public static CommandType getCommandType(String input) {
        for (CommandType commandType : values()) {
            if (commandType.getCommandString().equals(input)) {
                return commandType;
            }
        }
        return null;
    }
}
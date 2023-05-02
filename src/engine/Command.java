 package engine;

public class Command {
    private final CommandType commandType;
    private final String argument;

    public Command(CommandType commandType, String argument) {
        this.commandType = commandType;
        this.argument = argument;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public String getArgument() {
        return argument;
    }
}
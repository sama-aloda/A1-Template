package ca.mcmaster.se2aa4.mazerunner.command;

import java.util.ArrayList;
import java.util.List;

// handles command execution and history
public class CommandInvoker {
    private List<Command> history;
    
    public CommandInvoker() {
        this.history = new ArrayList<>();
    }
    
    // executes command and adds to history
    public void executeCommand(Command command) {
        history.add(command);
        command.execute();
    }
    
    // returns command execution history
    public List<Command> getHistory() {
        return history;
    }
}

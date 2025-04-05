package ca.mcmaster.se2aa4.mazerunner.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private List<Command> history;
    
    public CommandInvoker() {
        this.history = new ArrayList<>();
    }
    
    public void executeCommand(Command command) {
        history.add(command);
        command.execute();
    }
    
    public List<Command> getHistory() {
        return history;
    }
}

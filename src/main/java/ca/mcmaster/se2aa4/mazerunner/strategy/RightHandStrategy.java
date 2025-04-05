package ca.mcmaster.se2aa4.mazerunner.strategy;

import ca.mcmaster.se2aa4.mazerunner.RunnerStation;
import ca.mcmaster.se2aa4.mazerunner.command.CommandInvoker;
import ca.mcmaster.se2aa4.mazerunner.command.ForwardCommand;
import ca.mcmaster.se2aa4.mazerunner.command.RightCommand;
import ca.mcmaster.se2aa4.mazerunner.command.LeftCommand;
import ca.mcmaster.se2aa4.mazerunner.command.TurnAroundCommand;

public class RightHandStrategy {
    private RunnerStation station;
    private CommandInvoker invoker;

    public RightHandStrategy(RunnerStation station) {
        this.station = station;
        this.invoker = new CommandInvoker();
    }

    public void execute() {
        // run until exit is reached
        while (!station.isAtExit()) {
            // try right turn first
            if (station.canMoveRight()) {
                invoker.executeCommand(new RightCommand(station));
                invoker.executeCommand(new ForwardCommand(station));
            }
            // try forward
            else if (station.canMoveForward()) {
                invoker.executeCommand(new ForwardCommand(station));
            }
            // try left turn
            else if (station.canMoveLeft()) {
                invoker.executeCommand(new LeftCommand(station));
                invoker.executeCommand(new ForwardCommand(station));
            }
            // turn around if blocked
            else {
                invoker.executeCommand(new TurnAroundCommand(station));
                invoker.executeCommand(new ForwardCommand(station));
            }
        }
    }
}

package ca.mcmaster.se2aa4.mazerunner.command;

import ca.mcmaster.se2aa4.mazerunner.RunnerStation;

public class ForwardCommand implements Command {
    private RunnerStation station;
    
    public ForwardCommand(RunnerStation station) {
        this.station = station;
    }
    
    @Override
    public void execute() {
        station.moveForward();
    }
}

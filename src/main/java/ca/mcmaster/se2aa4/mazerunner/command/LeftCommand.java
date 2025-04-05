package ca.mcmaster.se2aa4.mazerunner.command;

import ca.mcmaster.se2aa4.mazerunner.RunnerStation;

public class LeftCommand implements Command {
    private RunnerStation station;
    
    public LeftCommand(RunnerStation station) {
        this.station = station;
    }
    
    @Override
    public void execute() {
        station.turnLeft();
    }
}

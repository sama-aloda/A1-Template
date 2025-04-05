package ca.mcmaster.se2aa4.mazerunner.command;

import ca.mcmaster.se2aa4.mazerunner.RunnerStation;

public class TurnAroundCommand implements Command {
    private RunnerStation station;
    
    public TurnAroundCommand(RunnerStation station) {
        this.station = station;
    }
    
    @Override
    public void execute() {
        station.turnAround();
    }
}

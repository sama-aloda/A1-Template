package ca.mcmaster.se2aa4.mazerunner.command;

import ca.mcmaster.se2aa4.mazerunner.RunnerStation;

// command to turn runner right
public class RightCommand implements Command {
    private RunnerStation station;
    
    public RightCommand(RunnerStation station) {
        this.station = station;
    }
    
    @Override
    public void execute() {
        station.turnRight();
    }
}

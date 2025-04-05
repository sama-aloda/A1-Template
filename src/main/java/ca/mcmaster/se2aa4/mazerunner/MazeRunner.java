package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import ca.mcmaster.se2aa4.mazerunner.observer.PathObserver;
import ca.mcmaster.se2aa4.mazerunner.strategy.PathChecker;
import ca.mcmaster.se2aa4.mazerunner.strategy.RightHandStrategy;

// main maze solving controller
public class MazeRunner {
    private final RunnerStation station;
    private final PathObserver pathObserver;

    public MazeRunner() {
        this.station = new RunnerStation();
        this.pathObserver = new PathObserver(station);
    }

    // loads maze from input
    public void loadMaze(BufferedReader reader) {
        station.initializeMaze(reader);
    }

    // finds path through maze
    public String findPath() {
        RightHandStrategy strategy = new RightHandStrategy(station);
        strategy.execute();
        return pathObserver.getFactorizedPath();
    }

    // validates given path
    public boolean validatePath(String path) {
        PathChecker checker = new PathChecker(station.getMaze());
        return checker.checkPath(path);
    }
}

package ca.mcmaster.se2aa4.mazerunner;

// represents the current state of the maze runner
public enum RunnerPhase {
    // initial state before movement
    START,
    // moving one step forward
    FORWARD,
    // turning 90 degrees right
    RIGHT, 
    // turning 90 degrees left
    LEFT,
    // turning 180 degrees around
    TURN;
}

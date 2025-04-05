package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;

// controls maze runner movement and state
public class RunnerStation extends RunnerSubject {
    private Maze maze;
    private Player player;
    private RunnerPhase phase;

    // initializes station with empty maze and player
    public RunnerStation() {
        super();
        this.maze = new Maze();
        this.player = new Player();
        this.phase = RunnerPhase.START;
    }

    // creates maze from input and sets player starting position
    public void initializeMaze(BufferedReader reader) {
        maze.mazeCreator(reader);
            for (int i = 0; i < maze.getMaze().size(); i++) {
                if (maze.getSpot(i, 0).getValue() == ' ') {
                    player.setSpot(new int[] {i, 0});
                    break;
                }
            }

    }

    // moves player forward if path is clear
    public void moveForward() {
        int[] frontSpot = player.checkFront();
        if (maze.getSpot(frontSpot[0], frontSpot[1]).getValue() == ' ') {
            player.forward();
            phase = RunnerPhase.FORWARD;
            notifyAllObservers();
        }
    }

    // turns player 90 degrees right
    public void turnRight() {
        player.right();
        phase = RunnerPhase.RIGHT;
        notifyAllObservers();
    }

    // turns player 90 degrees left
    public void turnLeft() {
        player.left();
        phase = RunnerPhase.LEFT;
        notifyAllObservers();
    }

    // turns player 180 degrees around
    public void turnAround() {
        player.right();
        player.right();
        phase = RunnerPhase.TURN;
        notifyAllObservers();
    }

    // returns current maze
    public Maze getMaze(){
        return maze;
    }

    // checks if player has reached maze exit
    public boolean isAtExit() {
        return player.getSpot()[1] == maze.getMaze().get(0).size() - 1;
    }

    // checks if forward movement is possible
    public boolean canMoveForward() {
        int[] frontSpot = player.checkFront();
        return maze.getSpot(frontSpot[0], frontSpot[1]).getValue() == ' ';
    }

    // checks if right movement is possible
    public boolean canMoveRight() {
        int[] rightSpot = player.checkRight();
        return maze.getSpot(rightSpot[0], rightSpot[1]).getValue() == ' ';
    }

    // checks if left movement is possible
    public boolean canMoveLeft() {
        int[] leftSpot = player.checkLeft();
        return maze.getSpot(leftSpot[0], leftSpot[1]).getValue() == ' ';
    }

    // returns current player
    public Player getPlayer() {
        return player;
    }

    // returns current movement phase
    public RunnerPhase getPhase() {
        return phase;
    }
}

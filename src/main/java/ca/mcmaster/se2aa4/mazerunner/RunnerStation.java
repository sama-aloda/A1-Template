package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;

public class RunnerStation extends RunnerSubject {
    private Maze maze;
    private Player player;
    private RunnerPhase phase;

    public RunnerStation() {
        super();
        this.maze = new Maze();
        this.player = new Player();
        this.phase = RunnerPhase.START;
    }

    public void initializeMaze(BufferedReader reader) {
        maze.mazeCreator(reader);
        if(player.getStartAngle()==0){
            for (int i = 0; i < maze.getMaze().size(); i++) {
                if (maze.getSpot(i, 0).getValue() == ' ') {
                    player.setSpot(new int[] {i, 0});
                    break;
                }
            }
        }else if(player.getStartAngle()==180){
            for (int i = 0; i < maze.getMaze().size(); i++) {
                if (maze.getSpot(i, maze.getMaze().get(0).size()-1).getValue() == ' ') {
                    player.setSpot(new int[] {i, maze.getMaze().get(0).size()});
                    break;
                }
            }
        }
    }

    public void moveForward() {
        int[] frontSpot = player.checkFront();
        if (maze.getSpot(frontSpot[0], frontSpot[1]).getValue() == ' ') {
            player.forward();
            phase = RunnerPhase.FORWARD;
            notifyAllObservers();
        }
    }

    public void turnRight() {
        player.right();
        phase = RunnerPhase.RIGHT;
        notifyAllObservers();
    }

    public void turnLeft() {
        player.left();
        phase = RunnerPhase.LEFT;
        notifyAllObservers();
    }

    public void turnAround() {
        player.right();
        player.right();
        phase = RunnerPhase.TURN;
        notifyAllObservers();
    }

    public boolean isAtExit() {
        return player.getSpot()[1] == maze.getMaze().get(0).size() - 1;
    }

    public boolean canMoveForward() {
        int[] frontSpot = player.checkFront();
        return maze.getSpot(frontSpot[0], frontSpot[1]).getValue() == ' ';
    }

    public boolean canMoveRight() {
        int[] rightSpot = player.checkRight();
        return maze.getSpot(rightSpot[0], rightSpot[1]).getValue() == ' ';
    }

    public boolean canMoveLeft() {
        int[] leftSpot = player.checkLeft();
        return maze.getSpot(leftSpot[0], leftSpot[1]).getValue() == ' ';
    }

    public Maze getMaze() {
        return maze;
    }

    public Player getPlayer() {
        return player;
    }

    public RunnerPhase getPhase() {
        return phase;
    }
}
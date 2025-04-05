package ca.mcmaster.se2aa4.mazerunner.strategy;

import ca.mcmaster.se2aa4.mazerunner.RunnerStation;
import ca.mcmaster.se2aa4.mazerunner.command.CommandInvoker;
import ca.mcmaster.se2aa4.mazerunner.command.ForwardCommand;
import ca.mcmaster.se2aa4.mazerunner.command.RightCommand;
import ca.mcmaster.se2aa4.mazerunner.command.LeftCommand;

public class PathValidator {
    private RunnerStation station;
    private CommandInvoker invoker;

    public PathValidator(RunnerStation station) {
        this.station = station;
        this.invoker = new CommandInvoker();
    }

    public boolean validatePath(String path) {
        //convert factorized path to canonical form if needed
        String canonicalPath=convertToCanonical(path);

        //execute each command in the path
        for (int i = 0; i <canonicalPath.length(); i++) {
            char command =canonicalPath.charAt(i);

            if (command =='F') {
                //check if we can move forward
                if (!station.canMoveForward()) {
                    return false; // Hit a wall
                }
                invoker.executeCommand(new ForwardCommand(station));
            } else if (command== 'R') {
                invoker.executeCommand(new RightCommand(station));
            } else if (command== 'L') {
                invoker.executeCommand(new LeftCommand(station));
            } else if (command!= ' ') {
                return false;
            }
        }

        //check if we reached the exit
        boolean isAtExit = station.isAtExit();
        return isAtExit;
    }

    private String convertToCanonical(String path) {
        if (path.length()<=0) {
            return "";
        }

        StringBuilder canonical = new StringBuilder();
        int i = 0;

        while (i < path.length()) {
            if (path.charAt(i)==' ') {
                i++;
                continue;
            }

            char currentChar = path.charAt(i);
            if (Character.isDigit(currentChar)) {
                int count = Character.getNumericValue(currentChar);
                if (i+1< path.length()) {
                    char command =path.charAt(i + 1);
                    for (int j=0; j<count; j++) {
                        canonical.append(command);
                    }
                }
                i += 2;
            } else {
                canonical.append(currentChar);
                i++;
            }
        }

        return canonical.toString();
    }
}

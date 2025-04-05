package ca.mcmaster.se2aa4.mazerunner.observer;

import ca.mcmaster.se2aa4.mazerunner.RunnerSubject;
import ca.mcmaster.se2aa4.mazerunner.*;


// tracks and records maze solution path
public class PathObserver extends Observer {
    private StringBuilder path;

    public PathObserver(RunnerSubject subject) {
        super(subject);
        this.path = new StringBuilder();
    }

    // records movement actions
    @Override
    public void update() {
        RunnerStation station = (RunnerStation) subject;
        RunnerPhase phase = station.getPhase();
        
        if (phase == RunnerPhase.FORWARD) {
            path.append("F");
        } else if (phase == RunnerPhase.RIGHT) {
            path.append("R");
        } else if (phase == RunnerPhase.LEFT) {
            path.append("L");
        } else if (phase == RunnerPhase.TURN) {
            path.append("RR");
        }
    }

    // returns raw path
    public String getPath() {
        return path.toString();
    }
    
    // returns compressed path notation
    public String getFactorizedPath() {
        if (path.length()==0) {
            return "";
        }
        
        StringBuilder factorized = new StringBuilder();
        char current = path.charAt(0);
        int count = 1;
        
        for (int i=1; i<path.length(); i++) {
            if (path.charAt(i) == current) {
                count++;
            } else {
                factorized.append(" ");
                if (count>1) {
                    factorized.append(count);
                }
                factorized.append(current);
                current = path.charAt(i);
                count = 1;
            }
        }
        
        factorized.append(" ");
        if (count>1) {
            factorized.append(count);
        }
        factorized.append(current);
        
        return factorized.toString();
    }
}

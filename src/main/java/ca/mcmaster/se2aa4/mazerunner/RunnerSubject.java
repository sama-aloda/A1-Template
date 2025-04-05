package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;
import ca.mcmaster.se2aa4.mazerunner.observer.Observer;

// base class for subject in observer pattern
public abstract class RunnerSubject {
    private List<Observer> observers;

    public RunnerSubject(){
        this.observers = new ArrayList<Observer>();
    }

    // adds observer to notification list
    public void attach(Observer ob){
        this.observers.add(ob);
    }

    // removes observer from notification list
    public void detach(Observer ob){
        this.observers.remove(ob);
    }

    // notifies all observers of state change
    public void notifyAllObservers(){
        for (Observer observer: observers){
            observer.update();
        }
    }
}

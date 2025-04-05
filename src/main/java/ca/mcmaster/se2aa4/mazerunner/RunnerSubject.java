package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;
import ca.mcmaster.se2aa4.mazerunner.observer.Observer;

public abstract class RunnerSubject{
    private List<Observer> observers;

    public RunnerSubject(){
        this.observers = new ArrayList<Observer>();
    }

    public void attach(Observer ob){
        this.observers.add(ob);
    }

    public void detach(Observer ob){
        this.observers.remove(ob);
    }

    public void notifyAllObservers(){
        for (Observer observer: observers){
            observer.update();
        }
    }
}
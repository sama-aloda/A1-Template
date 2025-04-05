package ca.mcmaster.se2aa4.mazerunner.observer;

import ca.mcmaster.se2aa4.mazerunner.RunnerSubject;

// base class for observer pattern implementation
public abstract class Observer {
    protected RunnerSubject subject;

    public Observer(RunnerSubject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    // method called when subject changes
    public abstract void update();
}

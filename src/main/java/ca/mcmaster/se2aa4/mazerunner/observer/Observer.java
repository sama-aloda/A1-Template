package ca.mcmaster.se2aa4.mazerunner.observer;

import ca.mcmaster.se2aa4.mazerunner.RunnerSubject;

public abstract class Observer{
    protected RunnerSubject subject;

    public Observer(RunnerSubject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
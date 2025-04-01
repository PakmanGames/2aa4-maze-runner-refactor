package ca.mcmaster.se2aa4.mazerunner.Runner;

import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Path.Subject;

public abstract class Observer {
    protected Subject subject;

    public Observer (Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update(char Direction);
}

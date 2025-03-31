package ca.mcmaster.se2aa4.mazerunner.Runner;

import ca.mcmaster.se2aa4.mazerunner.Solver.Subject;

public abstract class Observer {
    private Subject subject;

    public Observer (Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update();
}

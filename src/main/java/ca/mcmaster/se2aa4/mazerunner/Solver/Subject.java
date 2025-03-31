package ca.mcmaster.se2aa4.mazerunner.Solver;

import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.Runner.Observer;

public abstract class Subject {
    private List<Observer> observers;
    
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

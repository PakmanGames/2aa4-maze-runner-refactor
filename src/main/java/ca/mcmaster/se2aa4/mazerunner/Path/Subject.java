package ca.mcmaster.se2aa4.mazerunner.Path;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.Runner.Observer;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(char direction) {
        for (Observer observer : observers) {
            observer.update(direction);
        }
    }
}

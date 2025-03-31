package ca.mcmaster.se2aa4.mazerunner.Solver;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Runner.Observer;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(boolean rightWall, boolean frontWall, boolean leftWall, Path path) {
        for (Observer observer : observers) {
            observer.update(rightWall, frontWall, leftWall, path);
        }
    }
}

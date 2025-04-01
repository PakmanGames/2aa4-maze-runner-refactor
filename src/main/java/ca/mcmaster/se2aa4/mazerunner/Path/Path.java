package ca.mcmaster.se2aa4.mazerunner.Path;

public class Path extends Subject {
    StringBuilder path;

    public Path() {
        this.path = new StringBuilder();
    }

    public void add(char direction) {
        this.path.append(direction);
        this.notifyObservers(direction);
    }

    @Override
    public String toString() {
        return this.path.toString();
    }
}

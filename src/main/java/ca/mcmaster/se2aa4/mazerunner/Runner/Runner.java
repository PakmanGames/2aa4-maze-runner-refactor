package ca.mcmaster.se2aa4.mazerunner.Runner;

import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Solver.Subject;

public class Runner {
    private static Runner instance;
    private Location location;
    private Direction direction;

    private Runner() {
        // super(subject);
    }

    public static Runner getInstance() {
        if (instance == null) {
            instance = new Runner();
        }
        return instance;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public Location getLocation() {
        return this.location;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void move() {
        this.location = this.location.move(this.direction);
    }
}

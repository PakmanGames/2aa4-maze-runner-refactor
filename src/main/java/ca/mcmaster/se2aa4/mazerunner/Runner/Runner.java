package ca.mcmaster.se2aa4.mazerunner.Runner;

import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Solver.Subject;

public class Runner extends Observer {
    private static Runner instance;
    private Location location;
    private Direction direction;

    private Runner(Subject subject) {
        super(subject);
    }

    public static Runner getInstance(Subject subject) {
        if (instance == null) {
            instance = new Runner(subject);
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

    @Override
    public void update(boolean rightWall, boolean frontWall, boolean leftWall, Path path) {
        // Update the runner's direction based on the walls
        if (!rightWall) {
            this.turnRight();
            path.add('R');
        } else if (frontWall) {
            if (leftWall) {
                this.turnRight();
                this.turnRight();
                path.add('R');
                path.add('R');
            } else {
                this.turnLeft();
                path.add('L');
            }
        }
        this.move();
        path.add('F');
    }
}

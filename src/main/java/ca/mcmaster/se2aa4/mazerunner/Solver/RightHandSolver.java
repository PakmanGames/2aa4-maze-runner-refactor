package ca.mcmaster.se2aa4.mazerunner.Solver;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Path.CanonicalPath;
import ca.mcmaster.se2aa4.mazerunner.Path.FactorizedPath;
import ca.mcmaster.se2aa4.mazerunner.Runner.Runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver extends Subject implements Solver {
    private static final Logger logger = LogManager.getLogger();

    // Observer list and attach, detach methods here:

    // Notify Observers method here:

    @Override
    public String solve(Maze maze) {
        Location endLocation = maze.getEndLocation();
        Runner runner = Runner.getInstance(this);
        this.attach(runner);
        runner.setLocation(maze.getStartLocation());
        runner.setDirection(Direction.RIGHT);
        

        Path path = new FactorizedPath();

        while (!runner.getLocation().equals(endLocation)) {
            Location currentLocation = runner.getLocation();
            Direction currentDirection = runner.getDirection();

            // Check the tiles in the right, front, and left directions
            Location leftLocation = currentLocation.move(currentDirection.turnLeft());
            Location rightLocation = currentLocation.move(currentDirection.turnRight());
            Location forwardLocation = currentLocation.move(currentDirection);

            // Check if the tiles are walkable
            boolean leftWall = !maze.getTile(leftLocation).isWalkable();
            boolean frontWall = !maze.getTile(forwardLocation).isWalkable();
            boolean rightWall = !maze.getTile(rightLocation).isWalkable();

            // Notify observers with the wall information
            logger.info("Right Wall: {}, Front Wall: {}, Left Wall: {}", rightWall, frontWall, leftWall);
            notifyObservers(rightWall, frontWall, leftWall, path);
        }
        return FactorizedPath.convertToFactorized(CanonicalPath.convertToCanonical(path.toString()));
    }
}

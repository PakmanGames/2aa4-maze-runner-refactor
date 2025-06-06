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

public class RightHandSolver implements Solver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String solve(Maze maze) {
        Location endLocation = maze.getEndLocation();
        Path path = new FactorizedPath();
        Runner runner = Runner.getInstance(path);
        runner.setLocation(maze.getStartLocation());
        runner.setDirection(Direction.RIGHT);

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

            if (!rightWall) {
                path.add('R');
            } else if (frontWall) {
                if (leftWall) {
                    path.add('R');
                    path.add('R');
                } else {
                    path.add('L');
                }
            }
            path.add('F');
        }
        return FactorizedPath.convertToFactorized(CanonicalPath.convertToCanonical(path.toString()));
    }
}

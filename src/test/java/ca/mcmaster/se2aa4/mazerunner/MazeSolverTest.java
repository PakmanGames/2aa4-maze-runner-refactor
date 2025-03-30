package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Maze.MazeReader;
import ca.mcmaster.se2aa4.mazerunner.Solver.RightHandSolver;

import static org.junit.jupiter.api.Assertions.*;

public class MazeSolverTest {
    @Test
    public void testStraightMaze() {
        Maze maze = MazeReader.readMaze("examples/straight.maz.txt");
        RightHandSolver solver = new RightHandSolver();
        String path = solver.solve(maze);
        assertEquals("4F", path);
    }

    @Test
    public void testSmallMaze() {
        Maze maze = MazeReader.readMaze("examples/small.maz.txt");
        RightHandSolver solver = new RightHandSolver();
        String path = solver.solve(maze);
        String correctPath = "F R F 2R 2F R 2F R 2F 2R 4F R 2F R 4F 2R 2F R 4F R 2F R 2F 2R 2F L 2F L 4F R 2F R 2F 2R 4F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F R 2F L F";
        assertEquals(correctPath, path);
    }
}

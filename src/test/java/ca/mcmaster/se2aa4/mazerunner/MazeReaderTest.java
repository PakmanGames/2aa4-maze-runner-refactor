package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Maze.MazeReader;
import ca.mcmaster.se2aa4.mazerunner.Maze.Tile;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;

import static org.junit.jupiter.api.Assertions.*;

public class MazeReaderTest {
    @Test
    public void testReadStraightMaze() {
        Maze maze = MazeReader.readMaze("examples/straight.maz.txt");
        assertNotNull(maze);
        assertEquals(5, maze.getRowCount());
        assertEquals(5, maze.getColumnCount());
        assertEquals(Tile.WALL, maze.getTile(0, 0));
        assertEquals(Tile.WALL, maze.getTile(1, 1));
        assertEquals(Tile.PASS, maze.getTile(2, 1));

        Location startLocation = maze.getStartLocation();
        Location endLocation = maze.getEndLocation();
        
        assertEquals(startLocation, new Location(2, 0));
        assertEquals(endLocation, new Location(2, 4));
        assertEquals(Tile.PASS, maze.getTile(startLocation));
        assertEquals(Tile.PASS, maze.getTile(endLocation));
    }

    @Test
    public void testReadSmallMaze() {
        Maze maze = MazeReader.readMaze("examples/small.maz.txt");
        assertNotNull(maze);
        assertEquals(11, maze.getRowCount());
        assertEquals(11, maze.getColumnCount());
        assertEquals(Tile.WALL, maze.getTile(0, 0));
        assertEquals(Tile.WALL, maze.getTile(2, 2));
        assertEquals(Tile.PASS, maze.getTile(1, 1));

        Location startLocation = maze.getStartLocation();
        Location endLocation = maze.getEndLocation();
        
        assertEquals(startLocation, new Location(8, 0));
        assertEquals(endLocation, new Location(5, 10));
        assertEquals(Tile.PASS, maze.getTile(startLocation));
        assertEquals(Tile.PASS, maze.getTile(endLocation));
    }
}

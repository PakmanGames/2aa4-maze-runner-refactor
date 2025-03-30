package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.mazerunner.Maze.Tile;

public class TileTest {
    @Test
    public void testWallTile() {
        Tile wallTile = Tile.WALL;
        assertFalse(wallTile.isWalkable());
        assertEquals('#', wallTile.getSymbol());
        assertEquals(wallTile, Tile.fromSymbol('#'));
    }

    @Test
    public void testPassTile() {
        Tile passTile = Tile.PASS;
        assertTrue(passTile.isWalkable());
        assertEquals(' ', passTile.getSymbol());
        assertEquals(passTile, Tile.fromSymbol(' '));
    }
}
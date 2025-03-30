package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;

public class DirectionTest {
    @Test
    public void testOppositeDirections() {
        assertEquals(Direction.UP, Direction.DOWN.opposite());
        assertEquals(Direction.DOWN, Direction.UP.opposite());
        assertEquals(Direction.LEFT, Direction.RIGHT.opposite());
        assertEquals(Direction.RIGHT, Direction.LEFT.opposite());
    }

    @Test
    public void testTurningLeft() {
        assertEquals(Direction.LEFT, Direction.UP.turnLeft());
        assertEquals(Direction.RIGHT, Direction.DOWN.turnLeft());
        assertEquals(Direction.DOWN, Direction.LEFT.turnLeft());
        assertEquals(Direction.UP, Direction.RIGHT.turnLeft());
    }

    @Test
    public void testTurningRight() {
        assertEquals(Direction.RIGHT, Direction.UP.turnRight());
        assertEquals(Direction.LEFT, Direction.DOWN.turnRight());
        assertEquals(Direction.UP, Direction.LEFT.turnRight());
        assertEquals(Direction.DOWN, Direction.RIGHT.turnRight());
    }
}

package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;
import ca.mcmaster.se2aa4.mazerunner.Runner.Runner;

public class RunnerTest {
    @Test
    public void testIsNotNull() {
        Runner r = Runner.getInstance();
        assertNotNull(r);
    }

    @Test
    public void testIsSingleton() {
        Runner r1 = Runner.getInstance();
        Runner r2 = Runner.getInstance();
        assertSame(r1, r2);
    }

    @Test
    public void testLocation() {
        Runner r = Runner.getInstance();
        r.setLocation(new Location(0, 0));
        assertEquals(new Location(0, 0), r.getLocation());
    }

    @Test
    public void testDirection() {
        Runner r = Runner.getInstance();
        r.setDirection(Direction.RIGHT);
        assertEquals(Direction.RIGHT, r.getDirection());   
    }
}
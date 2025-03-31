package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;
import ca.mcmaster.se2aa4.mazerunner.Runner.Runner;
import ca.mcmaster.se2aa4.mazerunner.Solver.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.Solver.Subject;

public class RunnerTest {
    private Subject subject;

    @BeforeEach
    public void setUp() {
        this.subject = new RightHandSolver();
    }

    @Test
    public void testIsNotNull() {
        Runner r = Runner.getInstance(subject);
        assertNotNull(r);
    }

    @Test
    public void testIsSingleton() {
        Runner r1 = Runner.getInstance(subject);
        Runner r2 = Runner.getInstance(subject);
        assertSame(r1, r2);
    }

    @Test
    public void testLocation() {
        Runner r = Runner.getInstance(subject);
        r.setLocation(new Location(0, 0));
        assertEquals(new Location(0, 0), r.getLocation());
    }

    @Test
    public void testDirection() {
        Runner r = Runner.getInstance(subject);
        r.setDirection(Direction.RIGHT);
        assertEquals(Direction.RIGHT, r.getDirection());   
    }
}
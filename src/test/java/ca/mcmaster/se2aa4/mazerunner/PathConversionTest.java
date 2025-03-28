package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.mazerunner.Path.CanonicalPath;
import ca.mcmaster.se2aa4.mazerunner.Path.FactorizedPath;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;

public class PathConversionTest {
    @Test
    public void testFromCanonicalToFactorized() {
        Path p = new CanonicalPath();
        for (int i = 0; i < 4; i++) {
            p.add('F');
        }
        assertEquals("FFFF", p.toString());
        String factorizedP = FactorizedPath.convertToFactorized(p.toString());
        assertEquals("4F", factorizedP.toString());
    }

    @Test
    public void testFromFactorizedToCanonical() {
        Path p = new FactorizedPath();
        for (int i = 0; i < 4; i++) {
            p.add('F');
        }
        assertEquals("4F", p.toString());
        String canonicalP = CanonicalPath.convertToCanonical(p.toString());
        assertEquals("FFFF", canonicalP.toString());
    }
}

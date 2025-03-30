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

    @Test
    public void testLongPathConversion() {
        String factorizedPath = "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F";
        String expectedOutput = "F R F LL FF R FF R FF LL FFFF R FF R FFFF LL FF R FFFF R FF R FF LL FF L FF L FFFF R FF R FF LL FFFF R FF R FF LL FF R FF R FFFF R FF L FF R FF L F";

        String canonicalPath = CanonicalPath.convertToCanonical(factorizedPath);
        assertEquals(expectedOutput, canonicalPath);
    }
}

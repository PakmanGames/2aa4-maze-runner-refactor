package ca.mcmaster.se2aa4.mazerunner.Maze;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeReader {
    private static final Logger logger = LogManager.getLogger();
    public static Maze readMaze(String filename) {
        Maze maze = new Maze();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                List<Tile> row = new ArrayList<>();
                for (int idx = 0; idx < line.length(); idx++) {
                    row.add(Tile.fromSymbol(line.charAt(idx)));
                }
                maze.addRow(row);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Maze Start is at " + maze.getStartLocation());
        logger.info("Maze End is at " + maze.getEndLocation());
        logger.info("Maze Columns: " + maze.getColumnCount());
        logger.info("Maze Rows: " + maze.getRowCount());
        return maze;
    }
}
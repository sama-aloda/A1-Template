package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.StringReader;

public class MazeTest {
    
    private Maze maze;
    
    @BeforeEach
    public void setUp() {
        // initialize a new maze before each test
        maze = new Maze();
    }
    
    @Test
    public void testMazeCreation() {
        // create a simple maze
        String mazeStr = "###\n# #\n###";
        BufferedReader reader = new BufferedReader(new StringReader(mazeStr));
        
        maze.mazeCreator(reader);
        
        // check maze dimensions
        assertEquals(3, maze.getMaze().size()); // 3 rows
        assertEquals(3, maze.getMaze().get(0).size()); // 3 columns
    }
    
    @Test
    public void testGetSpot() {
        // create a simple maze
        String mazeStr = "###\n# #\n###";
        BufferedReader reader = new BufferedReader(new StringReader(mazeStr));
        
        maze.mazeCreator(reader);
        
        // check specific cells
        assertEquals('#', maze.getSpot(0, 0).getValue());
        assertEquals(' ', maze.getSpot(1, 1).getValue());
        assertEquals('#', maze.getSpot(2, 2).getValue());
    }
    
}

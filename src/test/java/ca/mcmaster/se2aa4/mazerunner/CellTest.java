package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testCellCreationWithValidValues() {
        Cell wallCell = new Cell('#');
        Cell pathCell = new Cell(' ');
        
        assertEquals('#', wallCell.getValue());
        assertEquals(' ', pathCell.getValue());
    }
    
    @Test
    public void testCellToString() {
        Cell wallCell = new Cell('#');
        Cell pathCell = new Cell(' ');
        
        assertEquals("#", wallCell.toString());
        assertEquals(" ", pathCell.toString());
    }
    
    @Test
    public void testSetValue() {
        Cell cell = new Cell(' ');
        cell.setValue('#');
        assertEquals('#', cell.getValue());
    }
    
}

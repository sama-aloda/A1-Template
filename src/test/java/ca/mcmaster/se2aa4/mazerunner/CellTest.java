package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testCellCreationWithValidValues() {
        // test creating cells with valid characters
        Cell wallCell = new Cell('#');
        Cell pathCell = new Cell(' ');
        
        // check if the cell values are set correctly
        assertEquals('#', wallCell.getValue());
        assertEquals(' ', pathCell.getValue());
    }
    
    @Test
    public void testCellToString() {
        // test the toString method of the cell
        Cell wallCell = new Cell('#');
        Cell pathCell = new Cell(' ');
        
        // check if the string representation matches the cell value
        assertEquals("#", wallCell.toString());
        assertEquals(" ", pathCell.toString());
    }
    
    @Test
    public void testSetValue() {
        // test setting a new value for the cell
        Cell cell = new Cell(' ');
        cell.setValue('#');
        
        // check if the new value is set correctly
        assertEquals('#', cell.getValue());
    }
    
}

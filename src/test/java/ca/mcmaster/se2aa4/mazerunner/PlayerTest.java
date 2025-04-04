package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    
    private Player player;
    
    @BeforeEach
    public void setUp() {
        player = new Player();
        player.setSpot(new int[]{5, 5});
        player.setAngle(0); // Facing east
    }
    
    @Test
    public void testInitialPosition() {
        int[] initialPosition = new int[]{-1, -1};
        Player newPlayer = new Player();
        assertArrayEquals(initialPosition, newPlayer.getSpot());
    }
    
    @Test
    public void testSetSpot() {
        int[] newSpot = new int[]{10, 10};
        player.setSpot(newSpot);
        assertArrayEquals(newSpot, player.getSpot());
    }
    
    @Test
    public void testMoveForward() {
        // Player is at (5,5) facing east (0 degrees)
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
        
        // Change direction to north (90 degrees) and move forward
        player.setAngle(90);
        player.forward();
        assertArrayEquals(new int[]{4, 6}, player.getSpot());
    }
    
    @Test
    public void testTurnRight() {
        // Player starts facing east (0 degrees)
        player.right();
        // Should now face south (270 degrees)
        player.forward();
        assertArrayEquals(new int[]{6, 5}, player.getSpot());
        
        // Turn right again to face west (180 degrees)
        player.right();
        player.forward();
        assertArrayEquals(new int[]{6, 4}, player.getSpot());
    }
    
    @Test
    public void testTurnLeft() {
        // Player starts facing east (0 degrees)
        player.left();
        // Should now face north (90 degrees)
        player.forward();
        assertArrayEquals(new int[]{4, 5}, player.getSpot());
        
        // Turn left again to face west (180 degrees)
        player.left();
        player.forward();
        assertArrayEquals(new int[]{4, 4}, player.getSpot());
    }
    
    @Test
    public void testCheckFront() {
        // Player is at (5,5) facing east (0 degrees)
        int[] frontSpot = player.checkFront();
        assertArrayEquals(new int[]{5, 6}, frontSpot);
        
        // Player position should not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
    }
    
    @Test
    public void testCheckRight() {
        // Player is at (5,5) facing east (0 degrees)
        int[] rightSpot = player.checkRight();
        assertArrayEquals(new int[]{6, 5}, rightSpot);
        
        // Player position and angle should not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
        
        // Move forward to confirm angle hasn't changed
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
    }
    
    @Test
    public void testCheckLeft() {
        // Player is at (5,5) facing east (0 degrees)
        int[] leftSpot = player.checkLeft();
        assertArrayEquals(new int[]{4, 5}, leftSpot);
        
        // Player position and angle should not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
        
        // Move forward to confirm angle hasn't changed
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
    }
}

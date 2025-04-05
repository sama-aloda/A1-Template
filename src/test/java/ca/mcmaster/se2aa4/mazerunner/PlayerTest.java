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
        player.setAngle(0); //facing east
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
        //player is at (5,5) facing east (0 degrees)
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
        
        //change direction to north (90 degrees) and move forward
        player.setAngle(90);
        player.forward();
        assertArrayEquals(new int[]{4, 6}, player.getSpot());
    }
    
    @Test
    public void testTurnRight() {
        //player starts facing east (0 degrees)
        player.right();
        //should now face south (270 degrees)
        player.forward();
        assertArrayEquals(new int[]{6, 5}, player.getSpot());
        
        //turn right again to face west (180 degrees)
        player.right();
        player.forward();
        assertArrayEquals(new int[]{6, 4}, player.getSpot());
    }
    
    @Test
    public void testTurnLeft() {
        //player starts facing east (0 degrees)
        player.left();
        //should now face north (90 degrees)
        player.forward();
        assertArrayEquals(new int[]{4, 5}, player.getSpot());
        
        //turn left again to face west (180 degrees)
        player.left();
        player.forward();
        assertArrayEquals(new int[]{4, 4}, player.getSpot());
    }
    
    @Test
    public void testCheckFront() {
        //player is at (5,5) facing east (0 degrees)
        int[] frontSpot = player.checkFront();
        assertArrayEquals(new int[]{5, 6}, frontSpot);
        
        //player position should not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
    }
    
    @Test
    public void testCheckRight() {
        //player is at (5,5) facing east (0 degrees)
        int[] rightSpot = player.checkRight();
        assertArrayEquals(new int[]{6, 5}, rightSpot);
        
        //player position and angle should not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
        
        //move forward to confirm angle hasn't changed
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
    }
    
    @Test
    public void testCheckLeft() {
        //player is at (5,5) facing east (0 degrees)
        int[] leftSpot = player.checkLeft();
        assertArrayEquals(new int[]{4, 5}, leftSpot);
        
        //player position and angle should not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
        
        //move forward to confirm angle hasn't changed
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
    }
}

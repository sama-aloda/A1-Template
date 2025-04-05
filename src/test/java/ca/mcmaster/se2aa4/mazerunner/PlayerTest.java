package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    
    private Player player;
    
    @BeforeEach
    public void setUp() {
        // initialize player with default values
        player = new Player();
        player.setSpot(new int[]{5, 5});
        player.setAngle(0); // facing east
    }
    
    @Test
    public void testInitialPosition() {
        // check initial position of a new player
        int[] initialPosition = new int[]{-1, -1};
        Player newPlayer = new Player();
        assertArrayEquals(initialPosition, newPlayer.getSpot());
    }
    
    @Test
    public void testSetSpot() {
        // set a new spot for the player
        int[] newSpot = new int[]{10, 10};
        player.setSpot(newSpot);
        assertArrayEquals(newSpot, player.getSpot());
    }
    
    @Test
    public void testMoveForward() {
        // move player forward while facing east
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
        
        // change direction to north and move forward
        player.setAngle(90);
        player.forward();
        assertArrayEquals(new int[]{4, 6}, player.getSpot());
    }
    
    @Test
    public void testTurnRight() {
        // turn player right from east to south
        player.right();
        player.forward();
        assertArrayEquals(new int[]{6, 5}, player.getSpot());
        
        // turn right again to face west
        player.right();
        player.forward();
        assertArrayEquals(new int[]{6, 4}, player.getSpot());
    }
    
    @Test
    public void testTurnLeft() {
        // turn player left from east to north
        player.left();
        player.forward();
        assertArrayEquals(new int[]{4, 5}, player.getSpot());
        
        // turn left again to face west
        player.left();
        player.forward();
        assertArrayEquals(new int[]{4, 4}, player.getSpot());
    }
    
    @Test
    public void testCheckFront() {
        // check the spot in front of the player
        int[] frontSpot = player.checkFront();
        assertArrayEquals(new int[]{5, 6}, frontSpot);
        
        // ensure player position does not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
    }
    
    @Test
    public void testCheckRight() {
        // check the spot to the right of the player
        int[] rightSpot = player.checkRight();
        assertArrayEquals(new int[]{6, 5}, rightSpot);
        
        // ensure player position and angle do not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
        
        // move forward to confirm angle hasn't changed
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
    }
    
    @Test
    public void testCheckLeft() {
        // check the spot to the left of the player
        int[] leftSpot = player.checkLeft();
        assertArrayEquals(new int[]{4, 5}, leftSpot);
        
        // ensure player position and angle do not change
        assertArrayEquals(new int[]{5, 5}, player.getSpot());
        
        // move forward to confirm angle hasn't changed
        player.forward();
        assertArrayEquals(new int[]{5, 6}, player.getSpot());
    }
}

package ca.mcmaster.se2aa4.mazerunner;

//Class Player for the player's actions in the maze
public class Player{
    
    private int[] spot;
    private int angle; //quadrant way, such that degree of 0 is East, degree of 90 is North, and so on
    private final int[][] spots={{0,1},{-1,0},{0,-1},{1,0}}; 

    public Player(){
        this.spot=new int[]{-1,-1};
    }

    //method below returns type void with parameter type of int[], taking in spot to set the spot.
    public void setSpot(int[] spot){
        this.spot=spot;
    }

    //method below returns type int[] of the player's current spot
    public int[] getSpot(){
        return spot;
    }

    //method below returns type void but takes in int angle to set the Player attribute angle
    public void setAngle(int angle){
        this.angle=angle;
    }

    //below method moves the Player forward depending on their angle
    //the return type of type int[] which signifies the new spot of the player, and it takes in no parameters
    public int[] forward(){
        spot[0]=spot[0]+spots[angle/90][0];
        spot[1]=spot[1]+spots[angle/90][1];
        return spot;
    }

    //below turns the player's direction to the right while ensuring they stay within the 0-360 (exclusive) limit
    //the return type of type void, and it takes in no parameters
    public void right(){
        angle=(angle-90)%360;
        if(angle<0)
            angle=360+angle;
    }

    //below turns the player's direction to the left while ensuring they stay within the 0-360(exclusive) limit
    //the return is of type void and it takes in no parameters
    public void left(){
        angle=(angle+90)%360;
    }

    //below returns the item currently to the right of the player, without changing its current angle or spot
    //the return is of type int[] returning the spot to the right
    public int[] checkRight(){ 
        int currAngle=angle;
        int[] currSpot= new int[2];
        currSpot[0] = spot[0];
        currSpot[1]=spot[1];
        right();
        int[] newSpot=forward();
        this.spot=currSpot;
        this.angle=currAngle;
        
        return newSpot;

    }

    //below returns the item currently to the left of the left, without changing its current angle or spot
    //the return is of type int[] returning the spot to the right
    public int[] checkLeft(){ 
        int currAngle=angle;
        int[] currSpot= new int[2];
        currSpot[0] = spot[0];
        currSpot[1]=spot[1];
        left();
        int[] newSpot=forward();
        this.spot=currSpot;
        this.angle=currAngle;
        
        return newSpot;

    }

    //below returns the item currently to the front of the player, without changing its current angle or spot
    //the return is of type int[] returning the spot to the front
    public int[] checkFront(){
        int[] currSpot= new int[2];
        currSpot[0] = spot[0];
        currSpot[1]=spot[1];
        int[] newSpot=forward();
        this.spot=currSpot;
        return newSpot;
    }

}
package ca.mcmaster.se2aa4.mazerunner;

// player movement and position tracking
public class Player{
    private int[] spot;
    // angle in degrees: 0=east, 90=north, 180=west, 270=south
    private int angle;
    private final int[][] spots={{0,1},{-1,0},{0,-1},{1,0}};
    private int start;

    public Player(){
        this.spot=new int[]{-1,-1};
        this.start=0;
    }

    // sets player position
    public void setSpot(int[] spot){
        this.spot=spot;
    }

    // gets current position
    public int[] getSpot(){
        return spot;
    }

    // sets player facing direction
    public void setAngle(int angle){
        this.angle=angle;
    }

    // moves player one step forward
    public int[] forward(){
        spot[0]=spot[0]+spots[angle/90][0];
        spot[1]=spot[1]+spots[angle/90][1];
        return spot;
    }

    // turns player 90 degrees right
    public void right(){
        angle=(angle-90)%360;
        if(angle<0)
            angle=360+angle;
    }

    // turns player 90 degrees left
    public void left(){
        angle=(angle+90)%360;
    }

    // checks spot to the right without moving
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

    // checks spot to the left without moving
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

    // checks spot in front without moving
    public int[] checkFront(){
        int[] currSpot= new int[2];
        currSpot[0] = spot[0];
        currSpot[1]=spot[1];
        int[] newSpot=forward();
        this.spot=currSpot;
        return newSpot;
    }
}

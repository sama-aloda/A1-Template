package ca.mcmaster.se2aa4.mazerunner;

public class Player{
    
    private int[] spot;
    private int angle; //quadrant way
    private final int[][] spots={{0,1},{-1,0},{0,-1},{1,0}};

    public Player(){
        this.spot=new int[]{-1,-1};
    }

    public void setSpot(int[] spot){
        this.spot=spot;
    }

    public int[] getSpot(){
        return spot;
    }

    public void setAngle(int angle){
        this.angle=angle;
    }

    public int[] forward(){
        spot[0]=spot[0]+spots[angle/90][0];
        spot[1]=spot[1]+spots[angle/90][1];
        return spot;
    }

    public void right(){
        angle=(angle-90)%360;
        if(angle<0)
            angle=360+angle;
    }

    public void left(){
        angle=(angle+90)%360;
    }


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

}
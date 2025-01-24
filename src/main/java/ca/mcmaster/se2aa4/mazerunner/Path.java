package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Path{
    Maze maze;
    String path;
    Player player;

    public Path(){
        maze=new Maze();
        path="";
        player=new Player();
    }

    public String getPath(){
        return path;
    }

    public Maze getMaze(){
        return maze;
    }

    public String pathParser(String p){
        int r=0;
        int f=0;
        int i=0;
        String newStr = "";
        while(i<p.length()){
            if(i==0){
                if(p.charAt(i)=='R')
                    r++;
                else
                    f++;
            }
            else{
                if(p.charAt(i-1)==p.charAt(i)){
                    if(p.charAt(i)=='R')
                        r++;
                    else
                        f++;
                }
                else {
                    if(f==0)
                        newStr+=r+"R";
                    else
                        newStr+=f+"F";
                    f=0;
                    r=0;
                    if(p.charAt(i)=='R')
                        r++;
                    else
                        f++;
                }
            }
            i++;
        }
        if(f==0)
            newStr+=r+"R";
        else
            newStr+=f+"F";
        return newStr;
    }
}

class PathFinder extends Path{

    public PathFinder(){
        super();
    }

    public void rightHand(){
        String actions="";
        for(int i=0;i<maze.getMaze().size();i++){ //find entry point of maze
            if(maze.getSpot(i,0).getValue()==' '){
                player.setSpot(new int[] {i,0});
                player.setAngle(0);
            }
        }
        
        System.out.println("Entry spot is at: "+player.getSpot()[0]+" "+player.getSpot()[1]);


        for(int i=0;i<maze.getMaze().get(0).size();i++){
            int[] toRight= player.checkRight();
            if(maze.getSpot(toRight[0],toRight[1]).getValue()=='#'){
                player.forward(); 
            }
            else{
                player.forward();
                player.right();
                path+="R";
            }
            path+="F";
            System.out.println(path+" is current path of the player.");
            System.out.println("Current Spot: "+player.getSpot()[0]+" "+player.getSpot()[1]);

        }   
        System.out.println("\n"+path+" is the final path.");
        System.out.println(super.pathParser(path)+" is the path parsed.");
        
    }
}
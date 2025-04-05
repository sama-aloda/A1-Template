package ca.mcmaster.se2aa4.mazerunner.strategy;

import ca.mcmaster.se2aa4.mazerunner.Player;
import ca.mcmaster.se2aa4.mazerunner.Maze;

//The class below checks whether a provided is a valid path to exit the maze.
//It extends class Path
public class PathChecker {
    private Maze maze;
    private String path;
    private Player player;

    public PathChecker(Maze maze){
        this.maze=maze;
        path="";
        player=new Player();
    }
    

    // checks if path string leads to maze exit
    public boolean checkPath(String path){
        path = getCanonicalForm(path);
        // find west exit
        int[] west = new int[2];
        for(int i=0;i<maze.getMaze().size();i++){ 
            if(maze.getSpot(i,0).getValue()==' '){
                west[0]=i;
                west[1]=0;
                break;
            }
        }
        // find east exit
        int[] east = new int[2];
        int last_col=maze.getMaze().get(0).size()-1;
        for(int i=0;i<maze.getMaze().size();i++){
            if(maze.getSpot(i,last_col).getValue()==' '){
                east[0]=i;
                east[1]=last_col;
                break;
            }
        }
        //below checks the provided string from west to east, then checks it rom east to west
        boolean first=checkPathAsStr(path,new int[]{west[0],west[1]},new int[]{east[0], east[1]},0);
        boolean second=checkPathAsStr(path,new int[]{east[0], east[1]},new int[]{west[0],west[1]}, 180);

        return first||second;
    }

    // validates path from entry to exit with given starting angle
    private boolean checkPathAsStr(String path, int[] entry, int[] exit, int angle){
        player.setSpot(entry);
        player.setAngle(angle);
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='F')
                player.forward();
            else if(path.charAt(i)=='R')
                player.right();
            else if(path.charAt(i)=='L')
                player.left();
            else if(path.charAt(i)!=' '){ // return false for invalid characters
                return false;
            }
            if(angle==0&&(player.getSpot()[0]>=maze.getMaze().size()||player.getSpot()[1]>=maze.getMaze().get(0).size())){
                return false;
            }
            else if(angle==180&&(player.getSpot()[0]<0||player.getSpot()[1]<0)){
                return false;
            }
            else{
                if(maze.isWall(player.getSpot())){
                    return false;
                }
            }
        }
        //below checks if player's spot is equal to the exit spot
        if(exit[0]==player.getSpot()[0]&&exit[1]==player.getSpot()[1]){
            return true;
        }
        return false;
    }

    public String getCanonicalForm(String p) {
        if (p == null || p.isEmpty()) {
            return "";
        }
        StringBuilder n = new StringBuilder();
        int i = 0;
        while (i < p.length()) {
            if (p.charAt(i) == ' ') {
                i++;
                continue;
            }
            int c = 0;
            while (i < p.length() && Character.isDigit(p.charAt(i))) {
                c = c*10 + (p.charAt(i)-'0');
                i++;
            }
            if (c == 0) {
                c = 1;
            }
            if (i < p.length()) {
                char prev = p.charAt(i);
                for (int j = 0; j < c; j++) {
                    n.append(prev);
                }
                n.append(" ");
                i++;
            }
        }
        return n.toString().trim();
}
}

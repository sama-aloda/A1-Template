package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.io.BufferedReader;

// maze representation and operations
public class Maze{
    private ArrayList<ArrayList<Cell>> maze;

    public Maze(){
        maze=new ArrayList<ArrayList<Cell>>();
    }

    // creates maze from input stream
    public void mazeCreator(BufferedReader reader){   
        int colsize= 0;
        try{
            String line;
            int row=0;
            while ((line = reader.readLine()) != null) {
                maze.add(new ArrayList<>());
                if(row==0)
                    colsize=line.length();
                for (int idx = 0; idx < colsize; idx++) {
                    if(idx>=line.length())
                        maze.get(row).add(new Cell(' '));
                    else 
                        maze.get(row).add(new Cell(line.charAt(idx)));
                }
                row++; 
            }
        }
        catch( Exception e){
            return;
        }
    }

    // returns maze structure
    public ArrayList<ArrayList<Cell>> getMaze(){
        return maze;
    }

    // gets cell at specified position
    public Cell getSpot(int row, int col){
        if(!maze.isEmpty())
            return maze.get(row).get(col);
        return new Cell('i');
    }

    // checks if position contains wall
    public boolean isWall(int[] spot){
        return maze.get(spot[0]).get(spot[1]).getValue()=='#';
    }
}

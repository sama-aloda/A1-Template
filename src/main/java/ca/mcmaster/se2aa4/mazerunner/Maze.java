package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Maze{
    
    private ArrayList<ArrayList<Cell>> maze;

    public Maze(){
        maze=new ArrayList<ArrayList<Cell>>();
    }

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
            System.out.println("Bad File input.");
            return;
        }
        
    }

    public ArrayList<ArrayList<Cell>> getMaze(){
        return maze;
    }

    public String toString(){
        String print="";
        for(int i=0;i<maze.size();i++){
            for(int j=0;j<maze.get(0).size();j++){
                print= print+maze.get(i).get(j);
            }
            print=print+"\n";
        }
        return print;
    }

    public Cell getSpot(int row, int col){
        if(!maze.isEmpty())
            return maze.get(row).get(col);
        return new Cell('i');
    }

}


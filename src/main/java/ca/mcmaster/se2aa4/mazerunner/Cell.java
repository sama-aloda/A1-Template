package ca.mcmaster.se2aa4.mazerunner;


public class Cell{
    private char value;

    public Cell(char value){
        this.value=value;
    }

    public char getValue(){
        return value;
    }

    public void setValue(char value){
        this.value=value;
    }

    public String toString(){
        return value+"";
    }
}
package ca.mcmaster.se2aa4.mazerunner;

//Class below is for the cell type
public class Cell{
    private char value;

    public Cell(char value){
        if(value!=' '&&value!='#')
            throw new IllegalArgumentException("Invalid value");
        this.value=value;
    }

    //below returns char attribute value
    //below takes in no parameters
    public char getValue(){
        return value;
    }

    //below sets the char value attribute to value given in the parameters
    //below method's return type is of type void
    public void setValue(char value){
        this.value=value;
    }

    //below returns the character value attribute as String
    public String toString(){
        return value+"";
    }
}
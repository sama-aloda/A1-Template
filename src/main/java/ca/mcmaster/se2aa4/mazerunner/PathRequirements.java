package ca.mcmaster.se2aa4.mazerunner;


//Class below is an interface, ensuring the subclass Path upholds the following methods
public interface PathRequirements{
    public String getPath();
    public Maze getMaze();
    public String getCanonicalForm(String p);
    public String getFactorizedForm(String p);

}
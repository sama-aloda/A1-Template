package ca.mcmaster.se2aa4.mazerunner;

public interface PathRequirements{
    public String getPath();
    public Maze getMaze();
    public String getCanonicalForm(String p);
    public String getFactorizedForm(String p);

}
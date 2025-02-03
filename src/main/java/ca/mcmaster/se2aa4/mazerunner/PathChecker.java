package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker extends Path{
    public PathChecker(){
        super();
    }

    private String reverse(String path){
        String newPath="";
        for(int i=0;i<path.length();i++){
            newPath=path.charAt(i)+newPath;
        }
        return newPath;
    }


    public boolean checkPath(String path){
        path= super.getCanonicalfromFactorized(path);
        //west exit
        int[] west = new int[2];
        for(int i=0;i<maze.getMaze().size();i++){ //find entry point of maze
            if(maze.getSpot(i,0).getValue()==' '){
                west[0]=i;
                west[1]=0;
            }
        }
        //east exit
        int[] east = new int[2];
        int last_col=maze.getMaze().get(0).size()-1;
        for(int i=0;i<maze.getMaze().size();i++){ //find entry point of maze
            if(maze.getSpot(i,last_col).getValue()==' '){
                east[0]=i;
                east[1]=last_col;
            }
        }
        boolean first=checkPathAsStr(path,west,east,0);
        boolean second=checkPathAsStr(reverse(path),east,west, 180);
        return first||second;
    }


    public boolean checkPathAsStr(String path, int[] entry, int[] exit, int angle){
        player.setSpot(entry);
        player.setAngle(angle);
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='F'){
                player.forward();
            }
            else if(path.charAt(i)=='R')
                player.right();
            else if(path.charAt(i)=='L')
                player.left();
            else if(path.charAt(i)!=' ')
                return false;
            if(angle==0&&(player.getSpot()[0]>=maze.getMaze().size()||player.getSpot()[1]>=maze.getMaze().get(0).size())){
                return false;
            }
            else if(angle==180&&(player.getSpot()[0]>=0||player.getSpot()[1]>=0)){
                return false;
            }

            else{
                if(maze.getSpot(player.getSpot()[0],player.getSpot()[1]).getValue()=='#'){
                    return false;
                }
            }
            

        }
        //find exit pt
        if(exit[0]==player.getSpot()[0]&&exit[1]==player.getSpot()[1]){
            return true;
        }
        return false;
    }
}
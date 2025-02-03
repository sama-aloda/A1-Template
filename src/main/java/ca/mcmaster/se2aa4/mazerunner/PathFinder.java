package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder extends Path{

    public PathFinder(){
        super();
    }

    public void rightHand(){
        for(int i=0;i<maze.getMaze().size();i++){ //find entry point of maze
            if(maze.getSpot(i,0).getValue()==' '){
                player.setSpot(new int[] {i,0});
                player.setAngle(0);
            }
        }
        

        while(player.getSpot()[1]<maze.getMaze().get(0).size()-1){
            int[] toRight= player.checkRight();
            int[] toFront=player.checkFront();
            int[] toLeft=player.checkLeft();

            if(maze.getSpot(toRight[0],toRight[1]).getValue()=='#'&& maze.getSpot(toFront[0], toFront[1]).getValue()==' '){//if can go forward
                player.forward(); 
            }
            else if(maze.getSpot(toRight[0],toRight[1]).getValue()=='#'&& maze.getSpot(toFront[0], toFront[1]).getValue()=='#'&& maze.getSpot(toLeft[0], toLeft[1]).getValue()=='#'){//if must turn back
                player.right();
                player.right();
                player.forward();
                path+="RR";
            }
            else if(maze.getSpot(toRight[0],toRight[1]).getValue()=='#'&& maze.getSpot(toFront[0], toFront[1]).getValue()=='#'&& maze.getSpot(toLeft[0], toLeft[1]).getValue()==' '){//if must turn left
                player.left();
                player.forward();
                path+="L";
            }
            else if(maze.getSpot(toRight[0],toRight[1]).getValue()==' '){ //if must turn right
                player.right();
                player.forward();
                path+="R";
            }
            path+="F";

        }
        System.out.println("Factorized Path: "+super.getFactorizedForm(path));
        
    }
}
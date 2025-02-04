package ca.mcmaster.se2aa4.mazerunner;

//Class below is an abstract class that has some of the functions needed for its subclasses
//The class below implements PathRequirements such that it must inherit and implement all of its functions as necessary
public abstract class Path implements PathRequirements{
    protected Maze maze;
    protected String path;
    protected Player player;

    public Path(){
        maze=new Maze();
        path="";
        player=new Player();
    }

    //method below returns the path as a String
    @Override
    public String getPath(){
        return path;
    }

    //method below returns the Maze as type Maze
    @Override
    public Maze getMaze(){
        return maze;
    }

    public String getCanonicalfromFactorized(String p){
        if(p.length()<=0)
            return "";
        int i=0;
        String n="";
        while(i<p.length()-1){
            if(p.charAt(i)==' '){
                i++;
            }
            else{
            try{
                int j= Integer.parseInt(p.substring(i,i+1));
                int z=0;
                while(z<j-1){
                    n+=p.charAt(i+1);
                    z++;
                }
                i++;
            }catch(NumberFormatException e){
                n+=p.charAt(i);
                i++;
            }
            }
        }
        n+=p.charAt(i);
        return n;
    }
    //method below returns a String after converting the String p into canonical form by adding spaces between letters
    //i.e. "FFFLL" becomes "FFF LL"
    @Override
    public String getCanonicalForm(String p){
        int r=0;
        int f=0;
        int i=0;
        int l=0;
        String newStr = "";
        while(i<p.length()){
            if(i==0){
                if(p.charAt(i)=='R')
                    newStr+="R";
                else if (p.charAt(i)=='F')
                    newStr+="F";
                else
                    newStr+="L";
            }
            else{
                if(p.charAt(i-1)==p.charAt(i)){
                    if(p.charAt(i)=='R')
                        newStr+="R";
                    else if (p.charAt(i)=='F')
                        newStr+="F";
                    else
                        newStr+="L";
                }
                else {
                    if(f==0&&l==0&&r!=1)
                        newStr+=" ";
                    else if (r==0&&l==0&&f!=1)
                        newStr+=" ";
                    else if(l!=1&&r==0&&f==0)
                        newStr+=" ";
                    else if(r==1)
                        newStr+=" ";
                    else if (f==1)
                        newStr+=" ";
                    else
                        newStr+=" ";
                    f=0;
                    r=0;
                    l=0;
                    if(p.charAt(i)=='R')
                        newStr+="R";
                    else if (p.charAt(i)=='F')
                        newStr+="F";
                    else
                        newStr+="L";
                }
            }
            i++;
        }
        if(f==0&&l==0&&r!=0)
            newStr+=r+"R";
        else if(r==0&&l==0&&f!=0) 
            newStr+=f+"F";
        else if(l!=0)
            newStr+=l+"L";
        return newStr;
    }

    //method below returns a String that is the factorized form of String p
    //e.g. "FFFL" becomes "3F L"
    @Override
    public String getFactorizedForm(String p){
        int r=0;
        int f=0;
        int i=0;
        int l=0;
        String newStr = "";
        while(i<p.length()){
            if(i==0){
                if(p.charAt(i)=='R')
                    r++;
                else if (p.charAt(i)=='F')
                    f++;
                else
                    l++;
            }
            else{
                if(p.charAt(i-1)==p.charAt(i)){
                    if(p.charAt(i)=='R')
                        r++;
                    else if (p.charAt(i)=='F')
                        f++;
                    else
                        l++;
                }
                else {
                    if(f==0&&l==0&&r!=1)
                        newStr+=r+"R ";
                    else if (r==0&&l==0&&f!=1)
                        newStr+=f+"F ";
                    else if(l!=1&&r==0&&f==0)
                        newStr+=l+"L ";
                    else if(r==1)
                        newStr+="R ";
                    else if (f==1)
                        newStr+="F ";
                    else
                        newStr+="L ";
                    f=0;
                    r=0;
                    l=0;
                    if(p.charAt(i)=='R')
                        r++;
                    else if (p.charAt(i)=='F')
                        f++;
                    else
                        l++;
                }
            }
            i++;
        }
        if(f==0&&l==0)
            newStr+=r+"R";
        else if(r==0&&l==0) 
            newStr+=f+"F";
        else
            newStr+=l+"L";
        return newStr;
    }
}


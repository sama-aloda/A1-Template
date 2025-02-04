package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.ArrayList;
import java.util.Arrays;



//Below class is the main class that calls on other functions as necessary
public class Main {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("i", true, "input maze to find path");
        options.addOption("p", true, "input path to see if viable");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        //below returns an error if arguments cannot be parsed properly
        try{
            cmd = parser.parse(options, args);
        }catch (Exception e){
            return;
        }
        
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i")));
            if(cmd.hasOption("i")&&cmd.hasOption("p")){ //below checks if path provided in the arguments is valid for maze provided
                PathChecker pathp = new PathChecker();
                pathp.getMaze().mazeCreator(reader);
                boolean valid=pathp.checkPath(cmd.getOptionValue("p"));
                if(valid)
                    System.out.println("Valid path.");
                else    
                    System.out.println("Invalid path.");
            }
            else if(cmd.hasOption("i")){ // below prints the factorized form of the path found using the right-hand principle
                PathFinder pathi = new PathFinder();
                pathi.getMaze().mazeCreator(reader);
                pathi.rightHand();
                }
        
        }catch (Exception e){ //bellow returns and fails silently if an error was found (i.e. bad file usage or invalid arguments)
            return;
        }           
        }
}



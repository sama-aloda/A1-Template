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




public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("human", false, "human mode"); 
        options.addOption("i", true, "input maze to find path");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try{
            cmd = parser.parse( options, args);
        }catch (Exception e){
            logger.info("way");
            return;
        }
        PathFinder pathi = new PathFinder();
        
      
        if(cmd.hasOption("i")){
            try{
                 
                logger.info("**** Reading the maze from file " + cmd.getOptionValue("i"));
                BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i")));
                pathi.getMaze().mazeCreator(reader);
                logger.info("**** Computing path");
                System.out.println(pathi.getMaze().toString());
                pathi.rightHand();
                logger.info("** End of MazeRunner");
                
                } catch(Exception e) {
                    logger.error("/!\\ An error has occured /!\\");
                }
                    }
                

            
            
        }


}



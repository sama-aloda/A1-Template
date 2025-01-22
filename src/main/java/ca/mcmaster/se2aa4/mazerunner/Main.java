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
      
        if(cmd.hasOption("i")){
            try{
                logger.info("**** Reading the maze from file " + cmd.getOptionValue("i"));
                BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i")));
                String line;
                while ((line = reader.readLine()) != null) {
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            logger.info("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            logger.info("PASS ");
                            }
                        }
                        logger.info(System.lineSeparator());
                    }
                } catch(Exception e) {
                    logger.error("/!\\ An error has occured /!\\");
                }
                    }
                logger.info("**** Computing path");
                logger.info("PATH NOT COMPUTED");
                logger.info("** End of MazeRunner");
            


}
}


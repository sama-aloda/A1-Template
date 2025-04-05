package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import ca.mcmaster.se2aa4.mazerunner.observer.PathObserver;
import ca.mcmaster.se2aa4.mazerunner.strategy.PathValidator;
import ca.mcmaster.se2aa4.mazerunner.strategy.RightHandStrategy;

/**
 * Main class for the MazeRunner application.
 */
public class Main {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("i", true, "input maze to find path");
        options.addOption("p", true, "input path to see if viable");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        //parse command line arguments
        try {
            cmd = parser.parse(options, args);
        } catch (Exception e) {
            System.err.println("Error parsing arguments: " + e.getMessage());
            return;
        }

        try {
            //check if input file is provided
            if (!cmd.hasOption("i")) {
                System.err.println("Input maze file is required");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i")));

            //create the RunnerStation (Subject)
            RunnerStation station = new RunnerStation();
            station.initializeMaze(reader);

            //create and attach observers
            PathObserver pathObserver = new PathObserver(station);

            if (cmd.hasOption("p")) {
                //validate a given path
                PathValidator validator = new PathValidator(station);
                boolean valid = validator.validatePath(cmd.getOptionValue("p"));

                if (valid) {
                    System.out.println("Valid path.");
                } else {

                    System.out.println("Invalid path.");
                }
            } else {
                //find a path using right-hand rule
                RightHandStrategy strategy = new RightHandStrategy(station);
                strategy.execute();
                String path = pathObserver.getFactorizedPath();
                System.out.println(path);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



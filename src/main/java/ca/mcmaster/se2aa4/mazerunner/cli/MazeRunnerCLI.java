package ca.mcmaster.se2aa4.mazerunner.cli;

import org.apache.commons.cli.*;
import java.io.BufferedReader;
import java.io.FileReader;

// handles command line interface
public class MazeRunnerCLI {
    private final Options options;
    
    public MazeRunnerCLI() {
        this.options = new Options();
        // setup cli options
        options.addOption("i", true, "input maze file");
        options.addOption("p", true, "path to validate");
    }
    
    // parse command line arguments
    public CLIResult parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            
            if (!cmd.hasOption("i")) {
                throw new ParseException("input maze file required");
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(cmd.getOptionValue("i")));
            String pathToCheck = cmd.hasOption("p") ? cmd.getOptionValue("p") : null;
            
            return new CLIResult(reader, pathToCheck);
            
        } catch (Exception e) {
            throw new RuntimeException("failed to parse cli arguments: " + e.getMessage());
        }
    }
    
    public static class CLIResult {
        public final BufferedReader reader;
        public final String pathToCheck;
        
        public CLIResult(BufferedReader reader, String pathToCheck) {
            this.reader = reader;
            this.pathToCheck = pathToCheck;
        }
    }
}

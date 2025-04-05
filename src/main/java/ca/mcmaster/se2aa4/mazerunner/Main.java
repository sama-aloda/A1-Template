package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.cli.MazeRunnerCLI;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse command line arguments
            MazeRunnerCLI cli = new MazeRunnerCLI();
            MazeRunnerCLI.CLIResult result = cli.parse(args);
            
            // Create and initialize maze runner
            MazeRunner runner = new MazeRunner();
            runner.loadMaze(result.reader);
            
            // Either validate a path or find a new one
            if (result.pathToCheck != null) {
                boolean isValid = runner.validatePath(result.pathToCheck);
                System.out.println(isValid ? "Valid path." : "Invalid path.");
            } else {
                String path = runner.findPath();
                System.out.println(path);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}



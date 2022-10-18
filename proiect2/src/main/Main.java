package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import input.InputData;
import simulation.Simulation;

import java.io.File;
import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            InputData inputData = objectMapper.readValue(new File(Constants.INPUT_PATH
                    + i
                    + Constants.FILE_EXTENSION), InputData.class);

            Simulation simulation = Simulation.getInstance(inputData);
            simulation.startSimulation(inputData, Constants.OUTPUT_PATH
                    + i
                    + Constants.FILE_EXTENSION, objectMapper);
            simulation.endSimulation();
        }

        Checker.calculateScore();
    }
}

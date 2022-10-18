package simulation;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import database.Child;
import database.Gift;
import database.Santa;
import enums.Category;
import factory.ChildFactory;
import input.ChildInput;
import input.InputData;
import input.PresentInput;
import output.ChildOutput;
import output.ChildrenOutput;
import output.DatabaseOutput;
import output.GiftOutput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class Simulation {

    private InputData inputData;
    private static Simulation simulation;

    /**
     *
     * @param inputData - datele de intrare din JSON
     * @return - returneaza o singura instanta a simularii
     */
    public static Simulation getInstance(final InputData inputData) {
        if (simulation == null) {
            simulation = new Simulation(inputData);
        }
        return simulation;
    }

    /**
     *
     * @param inputData - datele de intrare din JSON
     */
    private Simulation(final InputData inputData) {
        this.inputData = inputData;
    }

    /**
     * metoda care face instanta simulation = null,
     * deoarece toate testele ruleaza pe rand in acelasi program
     */
    public void endSimulation() {
        simulation = null;
    }

    /**
     *
     * @param file - fisierul de output
     * @param objectMapper - pentru writer
     * @throws IOException - exceptia
     * metoda in care se incepe jocul
     * (se citesc copiii si se incepe jocul: primul an + restul anilor)
     */
    public void startSimulation(final InputData inputdata,
                                final String file,
                                final ObjectMapper objectMapper) throws IOException {
        ArrayList<Child> children = new ArrayList<>();
        ArrayList<PresentInput> receivedGifts = new ArrayList<>();
        ChildrenOutput childrenOutput = new ChildrenOutput(new ArrayList<>());
        DatabaseOutput databaseOutput = new DatabaseOutput(new ArrayList<>());

        for (ChildInput childInput : inputdata.getInitialData().getChildren()) {
            Child child = new Child.Builder(childInput.getId(), childInput.getLastName(),
                    childInput.getFirstName(), childInput.getCity(),
                    childInput.getAge(), childInput.getGiftsPreferences(),
                    childInput.getNiceScore(), childInput.getNiceScoreBonus(),
                    childInput.getElf())
                    .niceScoreHistory()
                            .assignedBudget()
                                    .receivedGifts()
                                            .build();

            child.setStrategy(ChildFactory.createStrategy(child));
            if (child.getStrategy() != null) {
                child.setAverageScore(child.getStrategy().calculateAverageScore(child));
                child.setAverageScore(child.getAverageScore()
                        + child.getAverageScore() * child.getNiceScoreBonus()
                        / Constants.ONE_HUNDRED);
                if (child.getAverageScore() > Constants.MAX_AVERAGE_SCORE) {
                    child.setAverageScore(Constants.MAX_AVERAGE_SCORE);
                }
                children.add(child);
            }
        }

        ArrayList<Gift> santaGiftList = new ArrayList<>();
        for (PresentInput presentInput : inputdata.getInitialData().getSantaGiftsList()) {
            Gift gift = new Gift(presentInput.getProductName(), presentInput.getPrice(),
                    presentInput.getCategory(), presentInput.getQuantity());
            santaGiftList.add(gift);
        }

        Santa.getInstance().setupSanta(inputdata.getSantaBudget(), santaGiftList, children);

        for (Child child : children) {
            child.setAssignedBudget(Santa.getInstance().getChildBudget().get(child));
        }

        SimulationUpdates.applyElf(children);

        SimulationUpdates.shareGifts(children);

        SimulationUpdates.shareGiftsYellowElf(children);

        for (Child child : children) {
            ArrayList<Category> newGiftsPreferences = new ArrayList<>(child.getGiftsPreference());
            ArrayList<Double> newNiceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
            ArrayList<GiftOutput> newReceivedGifts = new ArrayList<>();

            for (Gift gift : child.getReceivedGifts()) {
                GiftOutput giftOutput = new GiftOutput(gift.getProductName(),
                        gift.getPrice(), gift.getCategory());
                newReceivedGifts.add(giftOutput);
            }

            ChildOutput childOutput = new ChildOutput(child.getId(), child.getLastName(),
                    child.getFirstName(), child.getCity(), child.getAge(), newGiftsPreferences,
                    child.getAverageScore(), newNiceScoreHistory,
                    child.getAssignedBudget(), newReceivedGifts);
            childrenOutput.getChildren().add(childOutput);
            ArrayList<Gift> newGifts = new ArrayList<>();
            child.setReceivedGifts(newGifts);
        }
        databaseOutput.getAnnualChildren().add(childrenOutput);


        for (int i = 0; i <= inputdata.getNumberOfYears() - 1; i++) {
            SimulationUpdates.updateGame(children, i, inputdata);
            childrenOutput = new ChildrenOutput(new ArrayList<>());
            for (Child child : children) {
                ArrayList<Category> newGiftsPreferences
                        = new ArrayList<>(child.getGiftsPreference());
                ArrayList<Double> newNiceScoreHistory
                        = new ArrayList<>(child.getNiceScoreHistory());
                ArrayList<GiftOutput> newReceivedGifts
                        = new ArrayList<>();

                for (Gift gift : child.getReceivedGifts()) {
                    GiftOutput giftOutput = new GiftOutput(gift.getProductName(),
                            gift.getPrice(), gift.getCategory());
                    newReceivedGifts.add(giftOutput);
                }

                ChildOutput childOutput = new ChildOutput(child.getId(), child.getLastName(),
                        child.getFirstName(), child.getCity(), child.getAge(),
                        newGiftsPreferences, child.getAverageScore(), newNiceScoreHistory,
                        child.getAssignedBudget(), newReceivedGifts);

                childrenOutput.getChildren().add(childOutput);
                ArrayList<Gift> newGifts = new ArrayList<>();
                child.setReceivedGifts(newGifts);
            }
            databaseOutput.getAnnualChildren().add(childrenOutput);
        }
        objectMapper.writeValue(new File(file), databaseOutput);
    }
}

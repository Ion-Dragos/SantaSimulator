package simulation;

import common.Constants;
import database.Child;
import database.ChildUpdate;
import database.Gift;
import database.Santa;
import enums.Category;
import enums.ElvesType;
import factory.ChildFactory;
import input.ChildInput;
import input.ChildUpdateInput;
import input.InputData;
import input.PresentInput;


import java.util.ArrayList;

public final class SimulationUpdates {

    private SimulationUpdates() {
        ///constructor for checkstyle
    }
    /**
     *
     * @param children - lista de copii
     * metoda care imparte cadourile la capii
     */
    public static void shareGifts(final ArrayList<Child> children) {

        Gift present;
        for (Child child : children) {
            Double buget = child.getAssignedBudget();
            for (Category category : child.getGiftsPreference()) {
                if (!child.getReceivedGifts().stream().anyMatch(c -> c.getCategory() == category)) {
                    present = getSmallestPrice(Santa.getInstance().getSantaGiftsList(), category);
                    if (present != null && present.getQuantity() != 0
                            && present.getPrice() < buget) {
                        child.getReceivedGifts().add(present);
                        buget = buget - present.getPrice();
                        present.setQuantity(present.getQuantity() - 1);
                    }
                }
            }
        }
    }


    /**
     *
     * @param gifts - lista de cadouri a mosului
     * @param category - categoria din care cautam cadoul
     * @return - cel mai ieftin cadou
     */
    public static Gift getSmallestPrice(final ArrayList<Gift> gifts, final Category category) {
        Double min = Constants.MIN;
        Gift smallest = null;
        for (Gift gift : gifts) {
            if (gift.getQuantity() != 0 && gift.getCategory() == category
                    && gift.getPrice() < min) {
                    min = gift.getPrice();
                    smallest = gift;
            }
        }
        return smallest;
    }

    /**
     *
     * @param gifts - lista de cadouri a mosului
     * @param category - categoria preferata de copil
     * @return - cel mai ieftin cadou
     */
    public static Gift getSmallestPriceYellow(final ArrayList<Gift> gifts,
                                              final Category category) {
        Double min = Constants.MIN;
        Gift smallest = null;
        for (Gift gift : gifts) {
            if (gift.getCategory() == category && gift.getPrice() < min) {
                min = gift.getPrice();
                smallest = gift;
            }
        }
        return smallest;
    }

    /**
     *
     * @param gifts - lista de preferinte vechi
     * @param newGifts - lista de preferinte noua
     * @return - lista combinata
     */
    public static ArrayList<Category> addNewPreferences(final ArrayList<Category> gifts,
                                                        final ArrayList<Category> newGifts) {

        for (Category category : gifts) {
            if (!newGifts.contains(category)) {
                newGifts.add(category);
            }
        }
        return newGifts;
    }

    /**
     *
     * @param children - lista de copii
     * @param noYear - anul in care se face schimbarile
     * @param inputData - inputData
     */
    public static void updateGame(final ArrayList<Child> children,
                                  final int noYear,
                                  final InputData inputData) {

        for (Child child : children) {
            child.setAge(child.getAge() + 1);
        }
        children.removeIf(child -> child.getAge() > Constants.TEEN_AGE_MARGIN);

        if (!inputData.getAnnualChanges().get(noYear).getNewChildren().isEmpty()) {
            for (ChildInput childInput
                    : inputData.getAnnualChanges().get(noYear).getNewChildren()) {
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
        }

        if (!inputData.getAnnualChanges().get(noYear).getChildrenUpdates().isEmpty()) {
            ArrayList<ChildUpdate> childUpdates = new ArrayList<>();
            for (ChildUpdateInput childUpdateInput
                    : inputData.getAnnualChanges().get(noYear).getChildrenUpdates()) {
                ChildUpdate childUpdate = new ChildUpdate(childUpdateInput.getId(),
                        childUpdateInput.getNiceScore(), childUpdateInput.getGiftsPreferences(),
                        childUpdateInput.getElf());
                childUpdates.add(childUpdate);
            }
            for (Child child : children) {
                for (ChildUpdate childUpdate : childUpdates) {
                    if (child.getId() == childUpdate.getId()) {
                        if (childUpdate.getNiceScore() != null) {
                            child.getNiceScoreHistory().add(childUpdate.getNiceScore());
                        }
                        if (!childUpdate.getGiftPreferences().isEmpty()) {
                            child.setGiftsPreference(addNewPreferences(child.getGiftsPreference(),
                                    childUpdate.getGiftPreferences()));
                        }
                        child.setElf(childUpdate.getElf());
                    }
                }
            }
        }

        for (Child child : children) {
            child.setStrategy(ChildFactory.createStrategy(child));
            if (child.getStrategy() != null) {
                child.setAverageScore(child.getStrategy().calculateAverageScore(child));
                child.setAverageScore(child.getAverageScore()
                        + child.getAverageScore() * child.getNiceScoreBonus()
                        / Constants.ONE_HUNDRED);
                if (child.getAverageScore() > Constants.MAX_AVERAGE_SCORE) {
                    child.setAverageScore(Constants.MAX_AVERAGE_SCORE);
                }
            }
        }

        if (!inputData.getAnnualChanges().get(noYear).getNewGifts().isEmpty()) {
            ArrayList<Gift> newSantaGifts = new ArrayList<>();
            for (PresentInput presentInput
                    : inputData.getAnnualChanges().get(noYear).getNewGifts()) {
                Gift gift = new Gift(presentInput.getProductName(),
                        presentInput.getPrice(), presentInput.getCategory(),
                        presentInput.getQuantity());
                newSantaGifts.add(gift);
            }
            for (Gift gift : newSantaGifts) {
                Santa.getInstance().getSantaGiftsList().add(gift);
            }
        }

        Santa.getInstance().setupSanta(inputData.getAnnualChanges().get(noYear).getNewSantaBudget(),
                Santa.getInstance().getSantaGiftsList(), children);

        for (Child child : children) {
            child.setAssignedBudget(Santa.getInstance().getChildBudget().get(child));
        }

        SimulationUpdates.applyElf(children);

        SimulationUpdates.chooseMethodSharingGifts(inputData, noYear, children);

        SimulationUpdates.shareGifts(children);

        SimulationUpdates.shareGiftsYellowElf(children);

        children.sort((child1, child2) -> Integer.compare(child1.getId(), child2.getId()));
    }

    /**
     *
     * @param children - lista de copii
     */
    public static void shareGiftsYellowElf(final ArrayList<Child> children) {
        Gift present;
        for (Child child : children) {
            if (child.getElf() == ElvesType.YELLOW && child.getReceivedGifts().isEmpty()) {
                present = getSmallestPriceYellow(Santa.getInstance().getSantaGiftsList(),
                        child.getGiftsPreference().get(0));
                if (present != null && present.getQuantity() != 0) {
                    child.getReceivedGifts().add(present);
                    present.setQuantity(present.getQuantity() - 1);
                }
            }
        }
    }

    /**
     *
     * @param children - lista de copii
     */
    public static void applyElf(final ArrayList<Child> children) {
        for (Child child : children) {
            switch (child.getElf()) {
                case WHITE -> {
                    break;
                }
                case BLACK -> {
                    child.setAssignedBudget(child.getAssignedBudget()
                            - child.getAssignedBudget() * Constants.THIRTY
                            / Constants.ONE_HUNDRED);
                    break;
                }
                case PINK -> {
                    child.setAssignedBudget(child.getAssignedBudget()
                            + child.getAssignedBudget() * Constants.THIRTY
                            / Constants.ONE_HUNDRED);
                    break;
                }
                default -> {
                    break;
                }
            }
        }
    }

    /**
     *
     * @param inputData - input data
     * @param noYear - numarul anului in care ne aflam
     * @param children - lista de copii
     */
    public static void chooseMethodSharingGifts(final InputData inputData,
                                                final int noYear,
                                                final ArrayList<Child> children) {
        switch (inputData.getAnnualChanges().get(noYear).getStrategy()) {
            case ID:
                children.sort((child1, child2) -> Integer.compare(child1.getId(), child2.getId()));
                break;

            case NICE_SCORE:
                children.sort((child1, child2) -> {
                    if (child1.getAverageScore() == child2.getAverageScore())  {
                        return Integer.compare(child1.getId(), child2.getId());
                    } else {
                        return -Double.compare(child1.getAverageScore(), child2.getAverageScore());
                    }
                });
                break;

            case NICE_SCORE_CITY:
                Santa.getInstance().setupNiceScoreCity();
                children.sort((child1, child2) ->
                        child1.getCity().toString().compareTo(child2.getCity().toString()));
                children.sort((child1, child2) ->
                        -Double.compare(Santa.getInstance().getCityScore().get(child1.getCity()),
                                Santa.getInstance().getCityScore().get(child2.getCity())));
                break;

            default:
                break;
        }
    }
}

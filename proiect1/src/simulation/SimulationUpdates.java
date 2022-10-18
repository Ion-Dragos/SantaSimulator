package simulation;

import common.Constants;
import database.Child;
import database.ChildUpdate;
import database.Gift;
import database.Santa;
import enums.Category;
import input.ChildInput;
import input.ChildUpdateInput;
import input.InputData;
import input.PresentInput;


import java.util.ArrayList;

public class SimulationUpdates {
    /**
     *
     * @param children - lista de copii
     * metoda care imparte cadourile la capii
     */
    public static void shareGifts(final ArrayList<Child> children) {

        Gift present;
        for (Child child : children) {
            for (Category category : child.getGiftsPreference()) {
                if (!child.getReceivedGifts().stream().anyMatch(c -> c.getCategory() == category)) {
                    present = getSmallestPrice(Santa.getInstance().getSantaGiftsList(), category);
                    if (present != null
                            && present.getPrice()
                            < Santa.getInstance().getChildBudget().get(child)) {
                        Santa.getInstance().getChildBudget().put(child,
                                Santa.getInstance().getChildBudget().get(child)
                                        - present.getPrice());
                        Santa.getInstance().setSantaBudget(Santa.getInstance().getSantaBudget()
                                - present.getPrice());
                        child.getReceivedGifts().add(present);
                    }
                }
            }
        }
    }


    private static Gift getSmallestPrice(final ArrayList<Gift> gifts, final Category category) {
        Double min = Constants.MIN;
        Gift smallest = null;
        for (Gift gift : gifts) {
            if (gift.getCategory() == category) {
                if (gift.getPrice() < min) {
                    min = gift.getPrice();
                    smallest = gift;
                }
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
                Child child = new Child(childInput.getId(), childInput.getLastName(),
                        childInput.getFirstName(), childInput.getCity(),
                        childInput.getAge(), childInput.getGiftsPreferences(),
                        childInput.getNiceScore());
                child.setupChild();
                if (child.getStrategy() != null) {
                    child.setAverageScore(child.getStrategy().calculateAverageScore(child));
                    children.add(child);
                }
            }
        }

        if (!inputData.getAnnualChanges().get(noYear).getChildrenUpdates().isEmpty()) {
            ArrayList<ChildUpdate> childUpdates = new ArrayList<>();
            for (ChildUpdateInput childUpdateInput
                    : inputData.getAnnualChanges().get(noYear).getChildrenUpdates()) {
                ChildUpdate childUpdate = new ChildUpdate(childUpdateInput.getId(),
                        childUpdateInput.getNiceScore(), childUpdateInput.getGiftsPreferences());
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
                    }
                }
            }
        }
        for (Child child : children) {
            child.setStrategy();
            if (child.getStrategy() != null) {
                child.setAverageScore(child.getStrategy().calculateAverageScore(child));
            }
        }



        if (!inputData.getAnnualChanges().get(noYear).getNewGifts().isEmpty()) {
            ArrayList<Gift> newSantaGifts = new ArrayList<>();
            for (PresentInput presentInput
                    : inputData.getAnnualChanges().get(noYear).getNewGifts()) {
                Gift gift = new Gift(presentInput.getProductName(),
                        presentInput.getPrice(), presentInput.getCategory());
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
        SimulationUpdates.shareGifts(children);
    }
}

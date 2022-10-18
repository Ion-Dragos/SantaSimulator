package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Santa {

    private Double santaBudget;
    private ArrayList<Gift> santaGiftsList;
    private ArrayList<Child> childrenList;
    private Map<Child, Double> childBudget = new HashMap<>();
    private static Santa santa;

    /**
     *
     * @return - instanta de santa
     */
    public static Santa getInstance() {
        if (santa == null) {
            santa = new Santa();
        }
        return santa;
    }

    /**
     *
     * @return - getter map-ul cu bugetul alocat fiecarui copil
     */
    public Map<Child, Double> getChildBudget() {
        return childBudget;
    }

    /**
     *
     * @param childBudget - setter map cu bugetul alocat fiecarui copil
     */
    public void setChildBudget(final Map<Child, Double> childBudget) {
        this.childBudget = childBudget;
    }

    /**
     *
     * @return - getter bugetul mosului
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     *
     * @param santaBudget - setter bugetul mosului
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     *
     * @return - getter lista de cadouri a mosului
     */
    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     *
     * @param santaGiftsList - setter lista de cadouri a mosului
     */
    public void setSantaGiftsList(final ArrayList<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    /**
     *
     * @return - getter lista de copii carora Mos Craciun trebuie sa le dea cadouri
     */
    public ArrayList<Child> getChildrenList() {
        return childrenList;
    }

    /**
     *
     * @param childrenList - setter lista de copii carora Mos Craciun trebuie sa le dea cadouri
     */
    public void setChildrenList(final ArrayList<Child> childrenList) {
        this.childrenList = childrenList;
    }

    /**
     *
     * @param santaBudget - bugetul
     * @param santaGiftsList - lista de cadouri noi
     * @param childrenList - lista de copii
     */
    public void setupSanta(final Double santabudget,
                           final ArrayList<Gift> santagiftslist,
                           final ArrayList<Child> childrenlist) {
        this.santaBudget = santabudget;
        this.santaGiftsList = santagiftslist;
        this.childrenList = childrenlist;
        setupChildBudget();
    }

    /**
     * metoda care seteaza bugetul copilului
     */
    public void setupChildBudget() {
        Double averageScoreSumAllChildren = 0.0;
        for (Child child : childrenList) {
            averageScoreSumAllChildren += child.getAverageScore();
        }
        Double budgetUnit = this.getSantaBudget() / averageScoreSumAllChildren;

        for (Child child : childrenList) {
            this.childBudget.put(child, budgetUnit * child.getAverageScore());
        }
    }
}

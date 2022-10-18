package database;

import enums.Cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Santa {

    private Double santaBudget;
    private ArrayList<Gift> santaGiftsList;
    private ArrayList<Child> childrenList;
    private Map<Child, Double> childBudget = new HashMap<>();
    private Map<Cities, ArrayList<Child>> niceCityScore = new HashMap<>();
    private Map<Cities, Double> cityScore = new HashMap<>();
    private static Santa santa;

    /**
     *
     * @return - instanta de Santa
     */
    public static Santa getInstance() {
        if (santa == null) {
            santa = new Santa();
        }
        return santa;
    }

    public Map<Child, Double> getChildBudget() {
        return childBudget;
    }

    public void setChildBudget(final Map<Child, Double> childBudget) {
        this.childBudget = childBudget;
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final ArrayList<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public ArrayList<Child> getChildrenList() {
        return childrenList;
    }

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

    public Map<Cities, ArrayList<Child>> getNiceCityScore() {
        return niceCityScore;
    }

    public void setNiceCityScore(final Map<Cities, ArrayList<Child>> niceCityScore) {
        this.niceCityScore = niceCityScore;
    }

    public Map<Cities, Double> getCityScore() {
        return cityScore;
    }

    public void setCityScore(final Map<Cities, Double> cityScore) {
        this.cityScore = cityScore;
    }

    /**
     * metoda care imi calculeaza scorul average pentru fiecare oras
     */
    public void setupNiceScoreCity() {

        for (Cities cities : Cities.values()) {
            ArrayList<Child> childrenInCity = new ArrayList<>();
            for (Child child : childrenList) {
                if (child.getCity() == cities) {
                    childrenInCity.add(child);
                }
            }
            childrenInCity.sort((child1, child2) ->
                    Integer.compare(child1.getId(), child2.getId()));
            niceCityScore.put(cities, childrenInCity);
        }

        for (Cities cities : Cities.values()) {
            Double sum = 0.0;
            for (Child child : niceCityScore.get(cities)) {
                sum += child.getAverageScore();
            }
            cityScore.put(cities, sum / niceCityScore.get(cities).size());
        }
    }
}

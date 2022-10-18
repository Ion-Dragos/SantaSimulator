package database;

import strategy.Strategy;
import enums.Category;
import enums.Cities;
import factory.ChildFactory;

import java.util.ArrayList;

public class Child {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private ArrayList<Category> giftsPreference;
    private Double niceScore;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;
    private Strategy strategy;

    public Child(final int id,
                 final String lastName,
                 final String firstName,
                 final Cities city,
                 final int age,
                 final ArrayList<Category> giftsPreference,
                 final Double niceScore) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreference = giftsPreference;
        this.niceScore = niceScore;
    }

    /**
     * metoda care adauga caracteristicile ce ne trebuiesc la output
     */
    public void setupChild() {
        setNiceScoreHistory(new ArrayList<>());
        this.niceScoreHistory.add(niceScore);
        assignedBudget = 0.0;
        receivedGifts = new ArrayList<>();
        setStrategy();
    }

    /**
     *
     * @return - getter id copil
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id - setter id copil
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     *
     * @return - getter nume copil
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName - setter nume copil
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return - getter prenume copil
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName - setter prenume copil
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return - getter oras copil
     */
    public Cities getCity() {
        return city;
    }

    /**
     *
     * @param city - setter oras copil
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     *
     * @return - getter varsta copil
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age - setter varsta copil
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     *
     * @return - getter lista de dorinte copil
     */
    public ArrayList<Category> getGiftsPreference() {
        return giftsPreference;
    }

    /**
     *
     * @param giftsPreference - setter lista de dorinte copil
     */
    public void setGiftsPreference(final ArrayList<Category> giftsPreference) {
        this.giftsPreference = giftsPreference;
    }

    /**
     *
     * @return - getter scor average copil
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     *
     * @param averageScore - setter scor average copil
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     *
     * @return - getter lista de scoruri average copil
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     *
     * @param niceScoreHistory - setter lista de scoruri average copil
     */
    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     *
     * @return - getter nice score copil
     */
    public double getNiceScore() {
        return niceScore;
    }

    /**
     *
     * @param niceScore - setter nice score copil
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     *
     * @return - getter buget copil
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     *
     * @param assignedBudget - setter buget copil
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     *
     * @return - getter lista de cadouri primite
     */
    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     *
     * @param receivedGifts - setter lista de cadouri copil
     */
    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * metoda care seteaza pentru fiecare copil in ce categorie de varsta se afla
     */
    public void setStrategy() {
        this.strategy = ChildFactory.createStrategy(this);
    }

    /**
     *
     * @return - getter strategy
     */
    public Strategy getStrategy() {
        return strategy;
    }
}

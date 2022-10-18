package output;

import database.Gift;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public class ChildOutput {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private ArrayList<Category> giftsPreferences;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;

    public ChildOutput(final int id,
                       final String lastName,
                       final String firstName,
                       final Cities city,
                       final int age,
                       final ArrayList<Category> giftsPreferences,
                       final Double averageScore,
                       final ArrayList<Double> niceScoreHistory,
                       final Double assignedBudget,
                       final ArrayList<Gift> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
    }

    /**
     *
     * @return - getter id output
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id - setter id output
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     *
     * @return - getter last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName - setter last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return - getter first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName - setter first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return - getter city
     */
    public Cities getCity() {
        return city;
    }

    /**
     *
     * @param city - setter city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     *
     * @return - getter varsta
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age - setter varsta
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     *
     * @return - getter lista de prefetinte
     */
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     *
     * @param giftsPreferences - setter lista de preferinte
     */
    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     *
     * @return - getter average score
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     *
     * @param averageScore - setter average score
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     *
     * @return - getter lista de average score-uri
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     *
     * @param niceScoreHistory - setter lista de average score-uri
     */
    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     *
     * @return - getter buget
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     *
     * @param assignedBudget - setter buget
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     *
     * @return - getter cadouri primite
     */
    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     *
     * @param receivedGifts - setter cadouri primite
     */
    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}

package input;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public class ChildInput {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

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
     * @return - getter oras copil
     */
    public Cities getCity() {
        return city;
    }

    /**
     *
     * @param city - getter oras copil
     */
    public void setCity(final Cities city) {
        this.city = city;
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
     * @return - getter lista de preferinte a copilului
     */
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     *
     * @param giftsPreferences - setter lista de preferinte a copilului
     */
    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}

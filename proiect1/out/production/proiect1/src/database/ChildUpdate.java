package database;

import enums.Category;

import java.util.ArrayList;

public class ChildUpdate {

    private int id;
    private Double niceScore;
    private ArrayList<Category> giftPreferences;

    public ChildUpdate(final int id,
                       final Double niceScore,
                       final ArrayList<Category> giftPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftPreferences = giftPreferences;
    }

    /**
     *
     * @return - getter id copil update
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id - setter id copil update
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     *
     * @return - getter niceScore copil update
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     *
     * @param niceScore - setter niceScore copil update
     */
    public void setNiceScore(final double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     *
     * @return - getter lista de preferinte a copilului
     */
    public ArrayList<Category> getGiftPreferences() {
        return giftPreferences;
    }

    /**
     *
     * @param giftPreferences - setter lista de preferinte a copilului
     */
    public void setGiftPreferences(final ArrayList<Category> giftPreferences) {
        this.giftPreferences = giftPreferences;
    }
}

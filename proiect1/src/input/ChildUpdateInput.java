package input;

import enums.Category;

import java.util.ArrayList;

public class ChildUpdateInput {
    private int id;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

    /**
     *
     * @return - getter Id copil ce trebuie updatadat
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id - setter id copil ce trebuie updatadat
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     *
     * @return - getter nice score nou
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     *
     * @param niceScore - setter nice score nou
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     *
     * @return - getter noi preferinte ale copilului
     */
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     *
     * @param giftsPreferences - setter noi pregerinte ale copilului
     */
    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {

        ArrayList<Category> newGiftList = new ArrayList<>();
        for (Category category : giftsPreferences) {
            if (!newGiftList.contains(category)) {
                newGiftList.add(category);
            }
        }
        this.giftsPreferences = newGiftList;
    }
}

package database;

import java.util.ArrayList;

public class AnnualChanges {

    private Double newSantaBudget;
    private ArrayList<Gift> newGifts;
    private ArrayList<Child> newChildren;
    private ArrayList<ChildUpdate> childrenUpdates;

    public AnnualChanges(final Double newSantaBudget,
                         final ArrayList<Gift> newGifts,
                         final ArrayList<Child> newChildren,
                         final ArrayList<ChildUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    /**
     *
     * @return - getter noul buget al mosului
     */
    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     *
     * @param newSantaBudget - setter noul buget al mosului
     */
    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     *
     * @return - getter noile cadouri ale mosului
     */
    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    /**
     *
     * @param newGifts - setter noile cadouri ale mosului
     */
    public void setNewGifts(final ArrayList<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     *
     * @return - getter copii noi
     */
    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    /**
     *
     * @param newChildren - setter copii noi
     */
    public void setNewChildren(final ArrayList<Child> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     *
     * @return - getter update copii
     */
    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     *
     * @param childrenUpdates - setter update copii
     */
    public void setChildrenUpdates(final ArrayList<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}

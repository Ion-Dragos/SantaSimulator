package database;

import java.util.ArrayList;

public final class AnnualChanges {

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

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final ArrayList<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final ArrayList<Child> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final ArrayList<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}

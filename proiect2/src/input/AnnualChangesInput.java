package input;

import enums.CityStrategyEnum;

import java.util.ArrayList;

public final class AnnualChangesInput {
    private Double newSantaBudget;
    private ArrayList<PresentInput> newGifts;
    private ArrayList<ChildInput> newChildren;
    private ArrayList<ChildUpdateInput> childrenUpdates;
    private CityStrategyEnum strategy;

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<PresentInput> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final ArrayList<PresentInput> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<ChildInput> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final ArrayList<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<ChildUpdateInput> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final ArrayList<ChildUpdateInput> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    public void setStrategy(final CityStrategyEnum strategy) {
        this.strategy = strategy;
    }
}

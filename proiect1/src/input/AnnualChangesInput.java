package input;

import java.util.ArrayList;

public class AnnualChangesInput {
    private Double newSantaBudget;
    private ArrayList<PresentInput> newGifts;
    private ArrayList<ChildInput> newChildren;
    private ArrayList<ChildUpdateInput> childrenUpdates;

    /**
     *
     * @return - getter noul buget al mosului
     */
    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     *
     * @param newSantaBudget - setter noul buget al mosului
     */
    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     *
     * @return - getter noile cadouri ale mosului
     */
    public ArrayList<PresentInput> getNewGifts() {
        return newGifts;
    }

    /**
     *
     * @param newGifts - setter noile cadouri ale mosului
     */
    public void setNewGifts(final ArrayList<PresentInput> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     *
     * @return - getter copii noi
     */
    public ArrayList<ChildInput> getNewChildren() {
        return newChildren;
    }

    /**
     *
     * @param newChildren - setter copii noi
     */
    public void setNewChildren(final ArrayList<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     *
     * @return - getter update copii
     */
    public ArrayList<ChildUpdateInput> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     *
     * @param childrenUpdates - setter update copii
     */
    public void setChildrenUpdates(final ArrayList<ChildUpdateInput> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}

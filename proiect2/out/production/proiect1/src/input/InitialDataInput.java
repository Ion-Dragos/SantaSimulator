package input;

import java.util.ArrayList;

public final class InitialDataInput {
    private ArrayList<ChildInput> children;
    private ArrayList<PresentInput> santaGiftsList;

    public ArrayList<ChildInput> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ChildInput> children) {
        this.children = children;
    }

    public ArrayList<PresentInput> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final ArrayList<PresentInput> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}

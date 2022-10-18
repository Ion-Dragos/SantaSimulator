package input;

import java.util.ArrayList;

public class InitialDataInput {
    private ArrayList<ChildInput> children;
    private ArrayList<PresentInput> santaGiftsList;

    /**
     *
     * @return - getter copii din input data
     */
    public ArrayList<ChildInput> getChildren() {
        return children;
    }

    /**
     *
     * @param children - setter copii din input data
     */
    public void setChildren(final ArrayList<ChildInput> children) {
        this.children = children;
    }

    /**
     *
     * @return - getter lista de cadouri ale mosului din input data
     */
    public ArrayList<PresentInput> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     *
     * @param santaGiftsList - setter lista de cadouri ale mosului din input data
     */
    public void setSantaGiftsList(final ArrayList<PresentInput> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}

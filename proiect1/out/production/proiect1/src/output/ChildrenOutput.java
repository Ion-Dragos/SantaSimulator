package output;

import java.util.ArrayList;

public class ChildrenOutput {
    private ArrayList<ChildOutput> children;

    public ChildrenOutput(final ArrayList<ChildOutput> children) {
        this.children = children;
    }

    /**
     *
     * @return - getter lista de copii pentru output
     */
    public ArrayList<ChildOutput> getChildren() {
        return children;
    }

    /**
     *
     * @param children - setter lista de copii pentru output
     */
    public void setChildren(final ArrayList<ChildOutput> children) {
        this.children = children;
    }
}

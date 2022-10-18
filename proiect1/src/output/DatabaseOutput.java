package output;

import java.util.ArrayList;

public class DatabaseOutput {

    private ArrayList<ChildrenOutput> annualChildren;

    public DatabaseOutput(final ArrayList<ChildrenOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }

    /**
     *
     * @return - getter lista anuala de copii
     */
    public ArrayList<ChildrenOutput> getAnnualChildren() {
        return annualChildren;
    }

    /**
     *
     * @param annualChildren - setter list anuala de copii
     */
    public void setAnnualChildren(final ArrayList<ChildrenOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }
}

package input;

import java.util.ArrayList;

public class InputData {
    private int numberOfYears;
    private Double santaBudget;
    private InitialDataInput initialData;
    private ArrayList<AnnualChangesInput> annualChanges;

    /**
     *
     * @return - getter numarul de ani pe care se desfasoara simularea
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     *
     * @param numberOfYears - setter numarul de ani pe care se desfasoara simularea
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     *
     * @return - getter bugetul mosului la inceput
     */
    public Double getSantaBudget() {
        return santaBudget;
    }

    /**
     *
     * @param santaBudget - setter bugetul mosului
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     *
     * @return - getter initial data
     */
    public InitialDataInput getInitialData() {
        return initialData;
    }

    /**
     *
     * @param initialData - setter initial data
     */
    public void setInitialData(final InitialDataInput initialData) {
        this.initialData = initialData;
    }

    /**
     *
     * @return - getter schimbari anuale
     */
    public ArrayList<AnnualChangesInput> getAnnualChanges() {
        return annualChanges;
    }

    /**
     *
     * @param annualChanges - setter schimbari anuale
     */
    public void setAnnualChanges(final ArrayList<AnnualChangesInput> annualChanges) {
        this.annualChanges = annualChanges;
    }
}

package input;

import java.util.ArrayList;

public final class InputData {
    private int numberOfYears;
    private Double santaBudget;
    private InitialDataInput initialData;
    private ArrayList<AnnualChangesInput> annualChanges;

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public InitialDataInput getInitialData() {
        return initialData;
    }

    public void setInitialData(final InitialDataInput initialData) {
        this.initialData = initialData;
    }

    public ArrayList<AnnualChangesInput> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(final ArrayList<AnnualChangesInput> annualChanges) {
        this.annualChanges = annualChanges;
    }
}

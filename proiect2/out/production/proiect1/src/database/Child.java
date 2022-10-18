package database;

import enums.ElvesType;
import strategy.ChildStrategy;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Child {
    private int id;                                 // mandatory
    private String lastName;                        // mandatory
    private String firstName;                       // mandatory
    private Cities city;                            // mandatory
    private int age;                                // mandatory
    private ArrayList<Category> giftsPreference;    // mandatory
    private Double niceScore;                       // mandatory
    private Double niceScoreBonus;                  // mandatory
    private ElvesType elf;                          // mandatory

    private Double averageScore;                    // optional
    private ArrayList<Double> niceScoreHistory;     // optional
    private Double assignedBudget;                  // optional
    private ArrayList<Gift> receivedGifts;          // optional
    private ChildStrategy strategy;                 // optional
    private Map<Cities, ArrayList<Child>> niceCityScore = new HashMap<>();
    private Map<Cities, Double> cityScore = new HashMap<>();

    public static final class Builder {
        private int id;                                 // mandatory
        private String lastName;                        // mandatory
        private String firstName;                       // mandatory
        private Cities city;                            // mandatory
        private int age;                                // mandatory
        private ArrayList<Category> giftsPreference;    // mandatory
        private Double niceScore;                       // mandatory
        private Double niceScoreBonus;                  // mandatory
        private ElvesType elf;                          // mandatory

        private ArrayList<Double> niceScoreHistory;     // optional
        private Double assignedBudget;                  // optional
        private ArrayList<Gift> receivedGifts;          // optional

        public Builder(final int id,
                       final String lastName,
                       final String firstName,
                       final Cities city,
                       final int age,
                       final ArrayList<Category> giftsPreference,
                       final Double niceScore,
                       final Double niceScoreBonus,
                       final ElvesType elf) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.city = city;
            this.age = age;
            this.giftsPreference = giftsPreference;
            this.niceScore = niceScore;
            this.niceScoreBonus = niceScoreBonus;
            this.elf = elf;
        }

        /**
         *
         * @return - adaug informatii despre niceScoreHistory
         */
        public Builder niceScoreHistory() {
            this.niceScoreHistory = new ArrayList<>();
            this.niceScoreHistory.add(niceScore);
            return this;
        }

        /**
         *
         * @return - adaug informatii despre bugetul copilului
         */
        public Builder assignedBudget() {
            this.assignedBudget = 0.0;
            return this;
        }

        /**
         *
         * @return - adaug informatii despre cadourile pe care le-a primit copilul
         */
        public Builder receivedGifts() {
            this.receivedGifts = new ArrayList<>();
            return this;
        }

        /**
         *
         * @return - construiesc intreg copilul
         */
        public Child build() {
            return new Child(this);
        }
    }

    private Child(final Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.city = builder.city;
        this.age = builder.age;
        this.giftsPreference = builder.giftsPreference;
        this.niceScore = builder.niceScore;
        this.niceScoreBonus = builder.niceScoreBonus;
        this.elf = builder.elf;
        this.niceScoreHistory = builder.niceScoreHistory;
        this.assignedBudget = builder.assignedBudget;
        this.receivedGifts = builder.receivedGifts;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public ArrayList<Category> getGiftsPreference() {
        return giftsPreference;
    }

    public void setGiftsPreference(final ArrayList<Category> giftsPreference) {
        this.giftsPreference = giftsPreference;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public ElvesType getElf() {
        return elf;
    }

    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    public void setStrategy(final ChildStrategy strategy) {
        this.strategy = strategy;
    }

    public ChildStrategy getStrategy() {
        return strategy;
    }

}

package strategy;

import database.Child;

public class KidConcreteStrategy implements ChildStrategy {

    /**
     *
     * @param child - copilul caruia vrem sa ii aflam strategia
     * @return - score-ul unui baby
     */
    @Override
    public Double calculateAverageScore(final Child child) {
        Double sum = 0.0;
        for (Double score : child.getNiceScoreHistory()) {
            sum += score;
        }

        return sum / child.getNiceScoreHistory().size();
    }
}

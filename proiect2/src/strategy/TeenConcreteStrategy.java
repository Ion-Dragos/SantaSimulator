package strategy;

import database.Child;

public class TeenConcreteStrategy implements ChildStrategy {

    /**
     *
     * @param child - copilul caruia vrem sa ii aflam strategia
     * @return - score-ul unui baby
     */
    @Override
    public Double calculateAverageScore(final Child child) {
        Double num = 0.0;
        Double denom = 0.0;

        for (int i = 1; i <= child.getNiceScoreHistory().size(); i++) {
            num += child.getNiceScoreHistory().get(i - 1) * i;
            denom += i;
        }

        return num / denom;
    }
}

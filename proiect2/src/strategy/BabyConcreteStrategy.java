package strategy;

import common.Constants;
import database.Child;

public class BabyConcreteStrategy implements ChildStrategy {

    /**
     *
     * @param child - copilul caruia vrem sa ii aflam strategia
     * @return - score-ul unui baby
     */
    @Override
    public Double calculateAverageScore(final Child child) {
        return Constants.BABY_SCORE;
    }
}

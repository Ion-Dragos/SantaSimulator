package strategy;

import database.Child;

public interface Strategy {
    /**
     *
     * @param child - copilul caruia vrem sa ii aflam strategia
     * @return - score-ul unui baby
     */
     Double calculateAverageScore(Child child);
}

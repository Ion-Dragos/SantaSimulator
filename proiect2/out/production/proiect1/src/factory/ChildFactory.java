package factory;

import strategy.BabyConcreteStrategy;
import strategy.KidConcreteStrategy;
import strategy.ChildStrategy;
import strategy.TeenConcreteStrategy;
import common.Constants;
import database.Child;

public final class ChildFactory {

    /**
     * for checkstyle
     */
    private ChildFactory() {

    }

    /**
     *
     * @param child - copilul caruia vrem sa ii aflam varsta
     * @return - metoda prin care o sa ii calculam averageScore-ul
     */
    public static ChildStrategy createStrategy(final Child child) {
        if (child.getAge() < Constants.BABY_AGE_MARGIN) {
            return new BabyConcreteStrategy();
        } else if (child.getAge() >= Constants.BABY_AGE_MARGIN
                && child.getAge() < Constants.KID_AGE_MARGIN) {
            return new KidConcreteStrategy();
        } else if (child.getAge() >= Constants.KID_AGE_MARGIN
                && child.getAge() <= Constants.TEEN_AGE_MARGIN) {
            return new TeenConcreteStrategy();
        }

        return null;
    }
}

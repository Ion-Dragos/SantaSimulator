package factory;

import strategy.BabyConcreteStrategy;
import strategy.KidConcreteStrategy;
import strategy.Strategy;
import strategy.TeenConcreteStrategy;
import common.Constants;
import database.Child;

public class ChildFactory {
    /**
     *
     * @param child - copilul caruia trebuie sa ii aflam varsta
     * @return
     */
    public static Strategy createStrategy(final Child child) {
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

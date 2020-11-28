package usantatecla.checkers;

import usantatecla.Interval;

public class LeftIntersectionChecker extends IntersectionChecker {
    public LeftIntersectionChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.max.value < interval.max.value && interval.min.value < compareInterval.max.value) {
            return true;
        }
        if (compareInterval.max.value > interval.max.value) {
            return true;
        }
        if (interval.min.isWithin(interval.min.value) && compareInterval.max.isWithin(compareInterval.max.value)) {
            return nextChecker.handle(interval,compareInterval);
        }
        return false;
    }
}

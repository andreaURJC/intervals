package usantatecla.checkers.leftcheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class PointIntersectionChecker extends IntersectionChecker {
    public PointIntersectionChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (interval.min.isWithin(interval.min.value) && compareInterval.max.isWithin(compareInterval.max.value)
                && Double.compare(compareInterval.max.value, interval.min.value) == 0) {
            return true;
        }
        return setNext(interval, compareInterval);
    }
}

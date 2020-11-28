package usantatecla.checkers.sidecheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class MiddleChecker extends IntersectionChecker {
    public MiddleChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (interval.max.isWithin(interval.max.value) && interval.min.isWithin(interval.min.value)
                && compareInterval.max.isWithin(compareInterval.max.value)
                && compareInterval.max.isWithin(compareInterval.max.value)
                && Double.compare(compareInterval.max.value, interval.max.value) == 0
                && Double.compare(compareInterval.min.value, interval.min.value) == 0) {
            return true;
        }
        return this.nextCheck(interval, compareInterval);
    }
}

package usantatecla.checkers.rightcheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class RightPointIntersectionChecker extends IntersectionChecker {
    public RightPointIntersectionChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (interval.max.isWithin(interval.max.value) && compareInterval.min.isWithin(compareInterval.min.value)
                && Double.compare(compareInterval.min.value, interval.max.value) == 0) {
            return true;
        }
        return this.setNext(interval,compareInterval);
    }
}

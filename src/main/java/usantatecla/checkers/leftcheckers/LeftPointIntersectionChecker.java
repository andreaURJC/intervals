package usantatecla.checkers.leftcheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class LeftPointIntersectionChecker extends IntersectionChecker {
    public LeftPointIntersectionChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (interval.min.isClosed() && compareInterval.max.isClosed()
                && Double.compare(compareInterval.max.value, interval.min.value) == 0) {
            return true;
        }
        return nextCheck(interval, compareInterval);
    }
}

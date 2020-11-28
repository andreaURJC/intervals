package usantatecla.checkers.sidecheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class MiddleChecker extends IntersectionChecker {
    public MiddleChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (interval.max.isClosed() && interval.min.isClosed()
                && compareInterval.max.isClosed()
                && compareInterval.max.isClosed()
                && Double.compare(compareInterval.max.value, interval.max.value) == 0
                && Double.compare(compareInterval.min.value, interval.min.value) == 0) {
            return true;
        }
        return this.nextCheck(interval, compareInterval);
    }
}

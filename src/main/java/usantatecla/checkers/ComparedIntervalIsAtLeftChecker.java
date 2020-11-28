package usantatecla.checkers;

import usantatecla.Interval;

public class ComparedIntervalIsAtLeftChecker extends IntersectionChecker {
    public ComparedIntervalIsAtLeftChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.min.value < interval.min.value) {
            nextChecker.handle(interval,compareInterval);
        }
        return false;
    }
}

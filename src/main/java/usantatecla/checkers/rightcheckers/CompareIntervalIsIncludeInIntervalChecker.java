package usantatecla.checkers.rightcheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class CompareIntervalIsIncludeInIntervalChecker extends IntersectionChecker {
    public CompareIntervalIsIncludeInIntervalChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.max.value < interval.max.value) {
            return true;
        }
        return this.setNext(interval, compareInterval);
    }
}

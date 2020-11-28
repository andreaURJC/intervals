package usantatecla.checkers.leftcheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class CompareIntervalIncludeIntervalChecker extends IntersectionChecker {
    public CompareIntervalIncludeIntervalChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.max.value > interval.max.value) {
            return true;
        }
        return this.setNext(interval, compareInterval);
    }
}

package usantatecla.checkers.leftcheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class LeftIntersectionChecker extends IntersectionChecker {
    public LeftIntersectionChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.max.value < interval.max.value && interval.min.value < compareInterval.max.value) {
            return true;
        }
        return this.setNext(interval,compareInterval);
    }
}

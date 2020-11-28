package usantatecla.checkers.rightcheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;

public class RightIntersectionChecker extends IntersectionChecker {
    public RightIntersectionChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.max.value > interval.max.value && interval.max.value > compareInterval.min.value) {
            return true;
        }
        return this.setNext(interval, compareInterval);
    }
}

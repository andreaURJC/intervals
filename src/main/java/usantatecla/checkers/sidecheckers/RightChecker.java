package usantatecla.checkers.sidecheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;
import usantatecla.checkers.rightcheckers.CompareIntervalIsIncludeInIntervalChecker;
import usantatecla.checkers.rightcheckers.RightIntersectionChecker;
import usantatecla.checkers.rightcheckers.RightPointIntersectionChecker;

public class RightChecker extends IntersectionChecker {

    private final IntersectionChecker rightPointIntersectionChecker = new RightPointIntersectionChecker(null);
    private final IntersectionChecker compareIntervalIsIncludedInInterval = new CompareIntervalIsIncludeInIntervalChecker(rightPointIntersectionChecker);
    private final IntersectionChecker rightIntersectionChecker = new RightIntersectionChecker(compareIntervalIsIncludedInInterval);

    public RightChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.min.value > interval.min.value) {
            return rightIntersectionChecker.handle(interval, compareInterval);
        }
        return this.setNext(interval, compareInterval);
    }
}

package usantatecla.checkers.sidecheckers;

import usantatecla.Interval;
import usantatecla.checkers.IntersectionChecker;
import usantatecla.checkers.leftcheckers.CompareIntervalIncludeIntervalChecker;
import usantatecla.checkers.leftcheckers.LeftIntersectionChecker;
import usantatecla.checkers.leftcheckers.LeftPointIntersectionChecker;

public class LeftChecker extends IntersectionChecker {

    private final IntersectionChecker pointIntersectionChecker = new LeftPointIntersectionChecker(null);
    private final IntersectionChecker compareIntervalIncludeIntervalChecker = new CompareIntervalIncludeIntervalChecker(pointIntersectionChecker);
    private final IntersectionChecker leftIntersectionChecker = new LeftIntersectionChecker(compareIntervalIncludeIntervalChecker);

    public LeftChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if (compareInterval.min.value < interval.min.value) {
            return leftIntersectionChecker.handle(interval, compareInterval);
        }
        return this.nextCheck(interval, compareInterval);
    }
}

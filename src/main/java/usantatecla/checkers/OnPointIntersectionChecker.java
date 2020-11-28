package usantatecla.checkers;

import usantatecla.Interval;

public class OnPointIntersectionChecker extends IntersectionChecker {
    public OnPointIntersectionChecker(IntersectionChecker nextChecker) {
        super(nextChecker);
    }

    public boolean handle(Interval interval, Interval compareInterval) {
        if(Double.compare(compareInterval.max.value, interval.min.value) == 0) {
            return true;
        }
        return false;
    }
}

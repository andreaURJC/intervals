package usantatecla.checkers;

import usantatecla.Interval;

public abstract class IntersectionChecker {
    protected IntersectionChecker nextChecker;

    public IntersectionChecker(IntersectionChecker nextChecker) {
        this.nextChecker = nextChecker;
    }

    public boolean nextCheck(Interval interval, Interval compareInterval) {
        if (nextChecker == null) {
            return false;
        }
        return nextChecker.handle(interval, compareInterval);
    }

    public abstract boolean handle(Interval interval, Interval compareInterval);
}

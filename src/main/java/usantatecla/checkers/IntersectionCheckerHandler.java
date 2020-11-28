package usantatecla.checkers;

import usantatecla.Interval;
import usantatecla.checkers.sidecheckers.LeftChecker;
import usantatecla.checkers.sidecheckers.MiddleChecker;
import usantatecla.checkers.sidecheckers.RightChecker;

public class IntersectionCheckerHandler {

    private final IntersectionChecker middleChecker = new MiddleChecker(null);
    private final IntersectionChecker rightChecker = new RightChecker(middleChecker);
    private final IntersectionChecker leftChecker = new LeftChecker(rightChecker);

    public boolean handle(Interval interval, Interval compareInterval) {
        return leftChecker.handle(interval, compareInterval);
    }
}

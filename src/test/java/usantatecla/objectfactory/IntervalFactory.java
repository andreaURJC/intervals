package usantatecla.objectfactory;

import usantatecla.Interval;
import usantatecla.IntervalBuilder;
import usantatecla.Point;

public class IntervalFactory implements IntervalObjectFactory {
    public Interval getSmallerIntersectedInterval(Interval interval) {
        Point min = new Point(interval.min.value);
        Point max = new Point(interval.max.value);

        return new IntervalBuilder().closed(min.getLess()).closed(max.getLess()).build();
    }

    public Interval getGreaterIntersectedInterval(Interval interval) {
        Point min = new Point(interval.min.value);
        Point max = new Point(interval.max.value);

        return new IntervalBuilder().closed(min.getGreater()).closed(max.getGreater()).build();
    }

    public Interval getSmallerContainedInterval(Interval interval) {
        return null;
    }

    public Interval getGreaterContainedInterval(Interval interval) {
        return null;
    }

    public Interval getSmallerNotIntersectedInterval(Interval interval) {
        return null;
    }

    public Interval getGreaterNotIntersectedInterval(Interval interval) {
        return null;
    }
}

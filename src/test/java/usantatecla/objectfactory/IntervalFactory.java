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

    public Interval getSmallerIntersectedOnPointInterval(Interval interval) {
        Point max = new Point(interval.min.value);

        return new IntervalBuilder().closed(max.getLess() - 1).closed(max.getEquals()).build();
    }

    public Interval getSmallerContainedInterval(Interval interval) {
        Point min = new Point(interval.min.value);
        Point max = new Point(interval.max.value);

        return new IntervalBuilder().closed(min.getGreater()).closed(max.getLess()).build();
    }

    public Interval getGreaterContainedInterval(Interval interval) {
        Point min = new Point(interval.min.value);
        Point max = new Point(interval.max.value);

        return new IntervalBuilder().closed(min.getLess()).closed(max.getGreater()).build();
    }

    public Interval getSameInterval(Interval interval) {
        return interval;
    }

    public Interval getSmallerNotIntersectedInterval(Interval interval) {
        Point max = new Point(interval.min.value);

        return new IntervalBuilder().closed(max.getLess() - 1).closed(max.getLess()).build();
    }

    public Interval getGreaterNotIntersectedInterval(Interval interval) {
        Point max = new Point(interval.max.value);

        return new IntervalBuilder().closed(max.getGreater()).closed(max.getGreater() + 1).build();
    }
}

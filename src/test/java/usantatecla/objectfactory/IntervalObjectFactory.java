package usantatecla.objectfactory;

import usantatecla.Interval;

public interface IntervalObjectFactory {
    Interval getSmallerIntersectedInterval(Interval interval);

    Interval getGreaterIntersectedInterval(Interval interval);

    Interval getSmallerIntersectedOnPointInterval(Interval interval);

    Interval getGreaterIntersectedOnPointInterval(Interval interval);

    Interval getSmallerContainedInterval(Interval interval);

    Interval getGreaterContainedInterval(Interval interval);

    Interval getSameInterval(Interval interval);

    Interval getSmallerNotIntersectedInterval(Interval interval);

    Interval getGreaterNotIntersectedInterval(Interval interval);
}


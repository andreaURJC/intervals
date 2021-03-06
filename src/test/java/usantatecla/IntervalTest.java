package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.objectfactory.IntervalFactory;

public class IntervalTest {

    private Point left = new Point(-2.2);
    private Point right = new Point(4.4);
    private IntervalBuilder intervalBuilder;
    private IntervalFactory intervalFactory;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);
        this.intervalBuilder = new IntervalBuilder();
        this.intervalFactory = new IntervalFactory();
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));
        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenSmallerIntersectedIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getSmallerIntersectedInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenGreaterIntersectedIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getGreaterIntersectedInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenSmallerIntersectedOnPointIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getSmallerIntersectedOnPointInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenGreaterIntersectedOnPointIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getGreaterIntersectedOnPointInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenSmallerIncludedIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getSmallerContainedInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenGreaterIncludedIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getGreaterContainedInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenEqualIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getSameInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenGreaterNotIntersectedIntervalWhenIsIntersectedThenReturnFalse() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getGreaterNotIntersectedInterval(interval);
        assertFalse(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenSmallerNotIntersectedIntervalWhenIsIntersectedThenReturnFalse() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getSmallerNotIntersectedInterval(interval);
        assertFalse(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenSmallerNotIntersectedOnPointIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.open(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getSmallerIntersectedOnPointInterval(interval);
        assertFalse(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenGreaterNotIntersectedOnPointIntervalWhenIsIntersectedThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).open(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getGreaterIntersectedOnPointInterval(interval);
        assertFalse(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenEqualOpenIntervalWhenIsIntersectedThenReturnFalse() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = new IntervalBuilder().open(this.left.getEquals()).open(this.right.getEquals()).build();
        assertFalse(interval.isIntersected(compareInterval));
    }
}
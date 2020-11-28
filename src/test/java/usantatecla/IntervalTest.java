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
    public void givenLeftIntersectedIntervalWhenIncludeThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getSmallerIntersectedInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }

    @Test
    public void givenRightIntersectedIntervalWhenIncludeThenReturnTrue() {
        Interval interval = this.intervalBuilder.closed(this.left.getEquals()).closed(this.right.getEquals()).build();
        Interval compareInterval = this.intervalFactory.getGreaterIntersectedInterval(interval);
        assertTrue(interval.isIntersected(compareInterval));
    }
}
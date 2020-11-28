package usantatecla;

import usantatecla.checkers.*;
import usantatecla.checkers.leftcheckers.CompareIntervalIncludeIntervalChecker;
import usantatecla.checkers.leftcheckers.LeftIntersectionChecker;
import usantatecla.checkers.leftcheckers.PointIntersectionChecker;

public class Interval {

    public Min min;
    public Max max;

    private IntersectionChecker pointIntersectionChecker = new PointIntersectionChecker(null);
    private IntersectionChecker compareIntervalIncludeIntervalChecker = new CompareIntervalIncludeIntervalChecker(pointIntersectionChecker);
    private IntersectionChecker leftIntersectionChecker = new LeftIntersectionChecker(compareIntervalIncludeIntervalChecker);

    public Interval(Min min, Max max) {
        assert min.value <= max.value;
        this.min = min;
        this.max = max;
    }

    public boolean include(double value) {
        return this.min.isWithin(value) && this.max.isWithin(value);
    }

    public boolean isIntersected(Interval comparedInterval) {
        if (comparedInterval.min.value < this.min.value) {
            return leftIntersectionChecker.handle(this,comparedInterval);
        }
        if (comparedInterval.min.value > this.min.value) {
            if (comparedInterval.max.value > this.max.value && this.max.value > comparedInterval.min.value) {
                return true;
            }
            if (this.max.isWithin(this.max.value) && comparedInterval.min.isWithin(comparedInterval.min.value)
                    && Double.compare(comparedInterval.min.value, this.max.value) == 0) {
                return true;
            }
            if (comparedInterval.max.value < this.max.value) {
                return true;
            }
        }
        if (this.max.isWithin(this.max.value) && this.min.isWithin(this.min.value)
                && comparedInterval.max.isWithin(comparedInterval.max.value)
                && comparedInterval.max.isWithin(comparedInterval.max.value)
                && Double.compare(comparedInterval.max.value, this.max.value) == 0
                && Double.compare(comparedInterval.min.value, this.min.value) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((max == null) ? 0 : max.hashCode());
        result = prime * result + ((min == null) ? 0 : min.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Interval other = (Interval) obj;
        if (max == null) {
            if (other.max != null)
                return false;
        } else if (!max.equals(other.max))
            return false;
        if (min == null) {
            if (other.min != null)
                return false;
        } else if (!min.equals(other.min))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.min.toString() + ", " + max.toString();
    }


}
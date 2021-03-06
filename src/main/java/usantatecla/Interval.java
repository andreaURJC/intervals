package usantatecla;


import usantatecla.checkers.IntersectionCheckerHandler;

public class Interval {

    public Min min;
    public Max max;

    public Interval(Min min, Max max) {
        assert min.value <= max.value;
        this.min = min;
        this.max = max;
    }

    private IntersectionCheckerHandler intersectionCheckerHandler = new IntersectionCheckerHandler();

    public boolean include(double value) {
        return this.min.isWithin(value) && this.max.isWithin(value);
    }

    public boolean isIntersected(Interval compareInterval) {
        return intersectionCheckerHandler.handle(this, compareInterval);
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
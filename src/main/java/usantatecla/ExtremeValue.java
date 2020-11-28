package usantatecla;

public abstract class ExtremeValue {

    public double value;

    public ExtremeValue(double value) {
        this.value = value;
    }

    public abstract boolean isWithin(double value);

    public boolean isClosed() {
        return this.isWithin(this.value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Min other = (Min) obj;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        return true;
    }

}

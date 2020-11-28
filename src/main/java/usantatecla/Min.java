package usantatecla;

public class Min extends ExtremeValue {

    public Min(double value) {
        super(value);
    }

    public boolean isWithin(double value) {
        return this.value < value;
    }

    @Override
    public String toString() {
        return "(" + this.value;
    }

}

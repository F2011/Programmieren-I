package exercises.classes.periodic;

public class Metal extends Element {
    protected boolean metalloid;
    protected double conductivity;

    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup, boolean metalloid, double conductivity) {
        super(name, symbol, ordinal, shell, phase, mainGroup);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }

    public Metal(String name, String symbol, int ordinal, char shell, boolean metalloid, double conductivity) {
        this(name, symbol, ordinal, shell, 1, true, metalloid, conductivity);
    }

    public boolean isMetalloid() {
        return metalloid;
    }

    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }

    public double getConductivity() {
        return conductivity;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + (metalloid ? "metalloid" : "metal") +
                ", σ = " + conductivity;
    }
}

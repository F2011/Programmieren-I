package exercises.classes.periodic;

public class Element {
    protected String name;
    protected String symbol;
    protected int ordinal;
    protected char shell;
    protected int phase;
    protected boolean mainGroup;

    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.mainGroup = mainGroup;
    }

    public Element(String name, String symbol, int ordinal, char shell) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = 3;
        this.mainGroup = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public boolean isMainGroup() {
        return mainGroup;
    }

    public void setMainGroup(boolean mainGroup) {
        this.mainGroup = mainGroup;
    }

    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        if (this.ordinal != ((Element) o).ordinal) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Element " + name +
                " (" + symbol +
                ") ordinal: " + ordinal +
                ", " + (phase == 1 ? "solid" : (phase == 2 ? "liquid" : "gaseous")) + "at 25°C (298K)" +
                ", " + (mainGroup ? "main group" : "side group");
    }
}

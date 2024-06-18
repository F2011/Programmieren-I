package exercises.collections.gas;

public class GasPrices {
    private double diesel;
    private double superE5;
    private double superE10;

    public void setPrices(double diesel, double superE5, double superE10) {
        this.diesel = diesel;
        this.superE5 = superE5;
        this.superE10 = superE10;
    }

    @Override
    public String toString() {
        return String.format("Diesel: %.2f, SuperE5: %.2f, SuperE10: %.2f", diesel, superE5, superE10);
    }
}

package exercises.control;

public class TemperatureTable {
    public static void main(String[] args) {
        System.out.print("Fahrenheit\t|\tCelsius\n");
        System.out.print("-----------------------\n");
        for (int i = 0; i < 301; i++) {
            System.out.printf("%3d\t\t\t|\t%3.1f\n", i, FtoC(i));
        }
    }

    private static double FtoC(double f) {
        return (5.0 / 9.0) * (f - 32);
    }
}

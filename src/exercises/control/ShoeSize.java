package exercises.control;

public class ShoeSize {
    public static void main(String[] args) {
        System.out.print("Zentimeter\t|\tGröße\n");
        System.out.print("----------------------\n");
        for (int g = 30; g < 50; g++) {
            System.out.printf("%.2f - %.2f\t|\t%d\n", GtoZ(g - 1), GtoZ(g), g);
        }
    }

    private static double GtoZ(int g) {
        return g/1.5;
    }
}
package exercises.control;

public class Deers {
    public static void main(String[] args) {
        int deers = 200;
        int counter = 1;
        do {
            deers = (int) (deers * 1.1 - 15);
            System.out.printf("%2d: %d Hirsche\n", counter, deers);
            counter++;
        } while (deers < 300);
    }
}

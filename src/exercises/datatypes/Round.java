package exercises.datatypes;

public class Round {
    public static void main(String[] args) {
        double pi = 3.1415926;
        double e  = 2.7182818;

        int piInt = (int) (pi + 0.5);
        int eInt = (int) (e + 0.5);

        System.out.println("Pi ganzzahlig: " + piInt);
        System.out.println("e ganzzahlig: " + eInt);
    }
}

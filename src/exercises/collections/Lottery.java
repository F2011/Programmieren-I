package exercises.collections;

import java.util.*;

public class Lottery {
    private List<Integer> numbers;

    public Lottery() {
        this.numbers = new LinkedList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int n;
            for (n = random.nextInt(1, 50); this.numbers.contains(n); n = random.nextInt(1, 50));
        this.numbers.add(n);
        }
        Collections.sort(this.numbers);
        int n;
        for (n = random.nextInt(1, 50); this.numbers.contains(n); n = random.nextInt(1, 50));
        this.numbers.add(n);
        for (int i = 0; i < 6; i++) {
            System.out.printf("%2d ", numbers.get(i));
        }
        System.out.println("Zusatzzahl: " + this.numbers.get(6));
    }

    public static void main(String[] args) {
        new Lottery();
    }
}

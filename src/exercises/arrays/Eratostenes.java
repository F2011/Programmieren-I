package exercises.arrays;

import java.util.Arrays;

public class Eratostenes {
    public static void main(String[] args) {
        for (int e : sieveOfEratostenes(20000000)) {
            System.out.print(e + "\t");
        }
    }

    public static int[] sieveOfEratostenes(int n) {
        if (n < 2) return new int[]{};
        else if (n == 2) return new int[]{2};

        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        int recent_prime_idx = 0;

        while (recent_prime_idx < Math.sqrt(n)) {
            while (!sieve[recent_prime_idx]) recent_prime_idx++;
            for (int i = 2 * recent_prime_idx; i < sieve.length; i += recent_prime_idx) {
                sieve[i] = false;
            }
            recent_prime_idx++;
        }

        int prime_length = 0;
        for (boolean number : sieve) {
            if (number) {
                prime_length++;
            }
        }
        int[] primes = new int[prime_length];
        int prime_counter = 0;
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                primes[prime_counter] = i;
                prime_counter++;
            }
        }
        return primes;
    }
}

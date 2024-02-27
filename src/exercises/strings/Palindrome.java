package exercises.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String word = sc.next();
        char[] word_as_char_array = word.toCharArray();
        StringBuilder backwards = new StringBuilder(word.length());
        for (int i = word_as_char_array.length - 1; i >= 0; i--) {
            backwards.append(word_as_char_array[i]);
        }

        System.out.printf("Umgekehrt: %s\n", backwards);
        if (isPalindrome(word.toLowerCase().toCharArray(), backwards.toString().toLowerCase().toCharArray())) {
            System.out.printf("%s ist ein Palindrom.\n", word);
        }
    }

    private static boolean isPalindrome(char[] word, char[] backwards) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] != backwards[backwards.length - i - 1]) return false;
        }
        return true;
    }
}

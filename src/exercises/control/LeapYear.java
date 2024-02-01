package exercises.control;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.printf("Type in the year you want to check: ");
        int year = sc.nextInt();
        String leap_year = (year % 4 == 0 ? (year % 100 == 0 ? (year % 400 == 0 ? "a" : "no") : "a") : "no");
        System.out.printf("The year %d is %s leap year.\n", year, leap_year);
    }
}

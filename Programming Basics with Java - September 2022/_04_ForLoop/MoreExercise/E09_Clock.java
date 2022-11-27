package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E09_Clock {
    public static void main(String[] args) {
        for (int hour = 0; hour <= 23; hour++) {
            for (int min = 0; min <= 59; min++) {
                System.out.printf("%d : %d%n", hour, min);
            }
        }
    }
}

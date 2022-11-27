package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E05_GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        double n1 = 0;
        double n2 = 0;
        double n3 = 0;
        double n4 = 0;
        double n5 = 0;
        double invalid = 0;
        for (int i = 1; i <= input; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            if (0 <= currentNum && currentNum <= 9) {
                n1++;
                sum += currentNum * 0.2;
            } else if (10 <= currentNum && currentNum <= 19) {
                n2++;
                sum += currentNum * 0.3;
            } else if (20 <= currentNum && currentNum <= 29) {
                n3++;
                sum += currentNum * 0.4;
            } else if (30 <= currentNum && currentNum <= 39) {
                n4++;
                sum += 50;
            } else if (40 <= currentNum && currentNum <= 50) {
                n5++;
                sum += 100;
            } else {
                invalid++;
                sum /= 2;
            }
        }
        System.out.printf("%.2f%n", sum);
        System.out.printf("From 0 to 9: %.2f%%%n", n1 / input * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", n2 / input * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", n3 / input * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", n4 / input * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", n5 / input * 100);
        System.out.printf("Invalid numbers: %.2f%%%n", invalid / input * 100);
    }
}

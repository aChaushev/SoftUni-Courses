package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E03_EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int setsNum = Integer.parseInt(scanner.nextLine());

        double setPrice = 0;
        if (fruit.equals("Watermelon")) {
            if (size.equals("small")) {
                setPrice = 56 * 2;
            } else if (size.equals("big")) {
                setPrice = 28.70 * 5;
            }
        } else if (fruit.equals("Mango")) {
            if (size.equals("small")) {
                setPrice = 36.66 * 2;
            } else if (size.equals("big")) {
                setPrice = 19.60 * 5;
            }
        } else if (fruit.equals("Pineapple")) {
            if (size.equals("small")) {
                setPrice = 42.10 * 2;
            } else if (size.equals("big")) {
                setPrice = 24.80 * 5;
            }
        } else if (fruit.equals("Raspberry")) {
            if (size.equals("small")) {
                setPrice = 20 * 2;
            } else if (size.equals("big")) {
                setPrice = 15.20 * 5;
            }
        }
        double totalSum = setsNum * setPrice;
        if (400 <= totalSum && totalSum <= 1000) {
            totalSum *= 0.85;
        } else if (totalSum > 1000) {
            totalSum *= 0.5;
        }
        System.out.printf("%.2f lv.", totalSum);
    }
}

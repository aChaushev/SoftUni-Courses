package PB_Exams.Exam_07_18and19July2020;

import java.util.Scanner;

public class E03_AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int windowsNum = Integer.parseInt(scanner.nextLine());
        String windowsFrames = scanner.nextLine();
        String deliveryMethod = scanner.nextLine();

        double price = 0;
        if (windowsFrames.equals("90X130")) {
            price = 110 * windowsNum;
            if (windowsNum > 60) {
                price *= 0.92;
            } else if (windowsNum > 30) {
                price *= 0.95;
            }
        } else if (windowsFrames.equals("100X150")) {
            price = 140 * windowsNum;
            if (windowsNum > 80) {
                price *= 0.9;
            } else if (windowsNum > 40) {
                price *= 0.94;
            }
        } else if (windowsFrames.equals("130X180")) {
            price = 190 * windowsNum;
            if (windowsNum > 50) {
                price *= 0.88;
            } else if (windowsNum > 20) {
                price *= 0.93;
            }
        } else if (windowsFrames.equals("200X300")) {
            price = 250 * windowsNum;
            if (windowsNum > 50) {
                price *= 0.86;
            } else if (windowsNum > 25) {
                price *= 0.91;
            }
        }
        if (deliveryMethod.equals("With delivery")) {
            price += 60;
        }
        if (windowsNum > 99) {
            price *= 0.96;
        }

        if (windowsNum <= 10) {
            System.out.println("Invalid order");
        } else {
            System.out.printf("%.2f BGN", price);
        }
    }
}

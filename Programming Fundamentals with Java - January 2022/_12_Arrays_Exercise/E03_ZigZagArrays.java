package _12_Arrays_Exercise;

import java.util.Scanner;

public class E03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] firstArr = new String[n];
        String[] secondArr = new String[n];
        for (int i = 0; i < n; i++) {
            String firstNum = scanner.next();
            String secondNum = scanner.next();
//            или
//            String[] numbers = scanner.nextLine().split(" ");
//            String firstNum = numbers[0];
//            String secondNum = numbers[1];
            if (i % 2 == 0) {
                firstArr[i] = firstNum;
                secondArr[i] = secondNum;
            } else {
                firstArr[i] = secondNum;
                secondArr[i] = firstNum;
            }
        }
        System.out.println(String.join(" ", firstArr));
        System.out.println(String.join(" ", secondArr));
    }
}

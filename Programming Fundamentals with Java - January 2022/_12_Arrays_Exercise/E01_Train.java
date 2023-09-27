package _12_Arrays_Exercise;

import java.util.Scanner;

public class E01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] peopleArr = new int[n];
        int elementsSum = 0;
        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            peopleArr[i] = currentNum;
            elementsSum += currentNum;
        }
        for (int element : peopleArr) {
            System.out.printf(element + " ");
        }
        System.out.printf("%n%d", elementsSum);
    }
}

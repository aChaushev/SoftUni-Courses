package _12_Arrays_Exercise;

import java.util.Scanner;

public class E02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String secondArrElement : secondArr) {
            for (String firstArrElement : firstArr) {
                if (secondArrElement.equals(firstArrElement)) {
                    System.out.printf("%s ", firstArrElement);
                    break;
                }
            }
        }
    }
}

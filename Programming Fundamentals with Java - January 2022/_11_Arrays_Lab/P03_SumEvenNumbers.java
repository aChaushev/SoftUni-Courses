package _11_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String[] inputArr = scanner.nextLine().split(" ");
//        int[] numbersArr = new int[inputArr.length];
//
//        for (int i = 0; i < numbersArr.length; i++) {
//            numbersArr [i] = Integer.parseInt(inputArr[i]);
//        }
        int[] numberArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        for (int i = 0; i < numberArr.length; i++) {
            if (numberArr[i] % 2 == 0) {
                evenSum += numberArr[i];
            }
        }
        System.out.println(evenSum);
    }
}

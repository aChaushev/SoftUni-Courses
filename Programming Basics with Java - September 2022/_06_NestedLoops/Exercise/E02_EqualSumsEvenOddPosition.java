package _06_NestedLoops.Exercise;

import java.util.Scanner;

public class E02_EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum; i++) {
            int currentNum = i;                 //String number = "" + i;
            int evenSum = 0;
            int oddSum =0;
            for (int j = 6; j >= 1; j--) {      // for (int j = 0; j < number.length(); j++) {
                int digit = currentNum % 10;    //int digit = Integer.parseInt("" + number.charAt(j))
                if (j % 2 == 0){
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
                currentNum /= 10;               //отпада
            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}

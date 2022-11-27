package _06_NestedLoops.Exercise;

import java.util.Scanner;

public class E05_SpecialNumbers_Mine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i <= 9999; i++) {
            int currentNum = i;
            int counter = 0;
            for (int j = 1; j <= 4; j++) {
                int digit = currentNum % 10;
                if (digit == 0){
                    break;
                }
                if (n % digit == 0) {
                    counter++;
                }
                currentNum /= 10;
            }
            if (counter == 4) {
                System.out.print(i + " ");
            }
        }
    }
}

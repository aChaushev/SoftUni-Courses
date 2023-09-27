package _12_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E09ArrayModifier_My {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] commandArr = scanner.nextLine().split(" ");
        while (!commandArr[0].equals("end")) {
            if (commandArr[0].equals("swap")) {
                int firstIndex = Integer.parseInt(commandArr[1]);
                int secondIndex = Integer.parseInt(commandArr[2]);
                int firstElement = numbersArr[firstIndex];
                numbersArr[firstIndex] = numbersArr[secondIndex];
                numbersArr[secondIndex] = firstElement;
            } else if (commandArr[0].equals("multiply")) {
                int firstIndex = Integer.parseInt(commandArr[1]);
                int secondIndex = Integer.parseInt(commandArr[2]);
                int firstElement = numbersArr[firstIndex] * numbersArr[secondIndex];
                numbersArr[firstIndex] = firstElement;
            } else if (commandArr[0].equals("decrease")) {
                for (int i = 0; i < numbersArr.length; i++) {
                    numbersArr[i] = numbersArr[i] - 1;
                }
            }
            commandArr = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < numbersArr.length; i++) {
            if (i < numbersArr.length - 1) {
                System.out.print(numbersArr[i] + ", ");
            } else {
                System.out.print(numbersArr[i]);
            }
        }
    }
}

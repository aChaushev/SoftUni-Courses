package _12_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.contains("swap")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                int firstElement = numbersArr[index1];
                numbersArr[index1] = numbersArr[index2];
                numbersArr[index2] = firstElement;
            } else if (command.contains("multiply")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                int firstElement = numbersArr[index1] * numbersArr[index2];
                numbersArr[index1] = firstElement;
            } else if (command.contains("decrease")) {
                for (int i = 0; i < numbersArr.length; i++) {
                    numbersArr[i] -= 1;
                    // numbersArr[i]--;
                }
            }
            command = scanner.nextLine();
        }

//        for (int i = 0; i < numbersArr.length; i++) {
//            if (i < numbersArr.length - 1) {
//                System.out.print(numbersArr[i] + ", ");
//            } else {
//                System.out.print(numbersArr[i]);
//            }
//        }
    }
}

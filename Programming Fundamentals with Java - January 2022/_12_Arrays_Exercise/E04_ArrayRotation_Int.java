package _12_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E04_ArrayRotation_Int {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotations; i++) {
            int firstElement = numberArr[0];
            for (int j = 0; j < numberArr.length - 1; j++) {
                numberArr[j] = numberArr[j + 1];
            }
            numberArr[numberArr.length - 1] = firstElement;
        }
        for (int element : numberArr) {
            System.out.print(element + " ");
        }
    }
}

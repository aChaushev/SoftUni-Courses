package _12_Arrays_Exercise;

import java.util.Scanner;

public class E04_ArrayRotation_StringNewArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numberArr = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotations; i++) {
            String[] newArr = new String[numberArr.length];
            for (int j = 0; j < numberArr.length; j++) {
                if (j < newArr.length - 1) {
                    newArr[j] = numberArr[j + 1];
                } else {
                    newArr[newArr.length - 1] = numberArr[0];
                }
            }
            numberArr = newArr;
        }
        System.out.println(String.join(" ", numberArr));
    }
}

package _12_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sequenceCnt = 1;
        int maxSequenceCnt = 0;
        int maxEqualElement = 0;
        for (int i = 0; i < numbersArr.length - 1; i++) {
            if (numbersArr[i] == numbersArr[i + 1]) {
                sequenceCnt++;
                int equalElement = numbersArr[i];
                if (sequenceCnt > maxSequenceCnt) {
                    maxSequenceCnt = sequenceCnt;
                    maxEqualElement = equalElement;
                }
            } else {
                sequenceCnt = 1;

            }
        }
        for (int i = 0; i < maxSequenceCnt; i++) {
            System.out.print(maxEqualElement + " ");
        }
    }
}

package _18_List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> bombNumberList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int bombNum = bombNumberList.get(0);
        int powerNum = bombNumberList.get(1);
        for (int i = 0; i <= numbersList.size() - 1; i++) {
            int currentNum = numbersList.get(i);
            if (currentNum == bombNum) {
                for (int j = i + powerNum; j >= i - powerNum; j--) {
                    if (j > numbersList.size() - 1) {
                        continue;
                    }
                    if (j < 0) {
                        break;
                    }
                    numbersList.remove(j);
                }
                i = -1;
            }
        }
        int elementsSum = 0;
        for (int element : numbersList) {
            elementsSum += element;
        }
        System.out.println(elementsSum);
    }
}

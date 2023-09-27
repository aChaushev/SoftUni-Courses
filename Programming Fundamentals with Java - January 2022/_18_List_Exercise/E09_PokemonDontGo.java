package _18_List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E09_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int removedElementsSum = 0;
        while (numbersList.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= numbersList.size() - 1) {
                int removedElement = numbersList.get(index);
                removedElementsSum += removedElement;
                numbersList.remove(index);
                modifyList(numbersList, removedElement);


            } else if (index < 0) {
                int firstElement = numbersList.get(0);
                removedElementsSum += firstElement;
                int lastElement = numbersList.get(numbersList.size() - 1);
                numbersList.set(0, lastElement);
                modifyList(numbersList, firstElement);


            } else if (index > numbersList.size() - 1) {
                int lastElement = numbersList.get(numbersList.size() - 1);
                removedElementsSum += lastElement;
                int firstElement = numbersList.get(0);
                numbersList.set(numbersList.size() - 1, firstElement);
                modifyList(numbersList, lastElement);

            }
        }
        System.out.println(removedElementsSum);
    }

    private static void modifyList(List<Integer> numbersList, int removedElement) {
        for (int i = 0; i <= numbersList.size() - 1; i++) {
            int currentNum = numbersList.get(i);
            if (currentNum <= removedElement) {
                numbersList.set(i, currentNum + removedElement);
            } else {
                numbersList.set(i, currentNum - removedElement);
            }
        }
    }
}

package _12_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        Function<List<Integer>, List<Integer>> addOne =
                list -> list.stream().map(number -> number + 1).collect(Collectors.toList());
        // подаваме списак и получаваме списък с добавено 1 към всеки елемент

        Function<List<Integer>, List<Integer>> multiplyByTwo =
                list -> list.stream().map(number -> number * 2).collect(Collectors.toList());
        // подаваме списак и получаваме списък, всеки елемент на който е умножен с 2

        Function<List<Integer>, List<Integer>> subtractOne =
                list -> list.stream().map(number -> number - 1).collect(Collectors.toList());
        // подаваме списак и получаваме списък с извадено 1 от всеки елемент

        Consumer<List<Integer>> printList = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    printList.accept(numbers);
                    System.out.println();
                    break;

            }
            command = scanner.nextLine();
        }

    }
}

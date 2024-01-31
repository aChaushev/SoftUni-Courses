package _12_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        решение I
//        String[] namesArr = scanner.nextLine().split("\\s+");
//
//        Consumer<String> printName = name -> System.out.println(name); // или System.out::println;
//
//        Arrays.stream(namesArr).forEach(printName);


//        решение II
//        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(System.out::println);


//        решение III
        Consumer<String[]> printArray = array -> Arrays.stream(array).forEach(System.out::println);

        String[] namesArr = scanner.nextLine().split("\\s+");

        printArray.accept(namesArr);
    }
}

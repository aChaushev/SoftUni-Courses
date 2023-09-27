package _15_Methods_Exercise;

import java.util.Scanner;

public class E02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        printVowelsCnt(input);

    }

    public static void printVowelsCnt(String input) {
        String lowerCharText = input.toLowerCase();
        int vowelCnt = 0;
        for (char symbol : lowerCharText.toCharArray()) {
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                vowelCnt++;
            }
        }
        System.out.println(vowelCnt);
    }
}

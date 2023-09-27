package _14_Methods;

import java.util.Scanner;

public class P07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String repeatText = repeatString(n, inputText);
        System.out.println(repeatText);
    }

    public static String repeatString(int n, String text) {
        String result = "";
        for (int i = 1; i <= n; i++) {
            result += text;
        }
        return result;
    }
}

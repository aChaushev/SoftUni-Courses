package _05_BasicSyntax_Lab;

import java.util.Scanner;

public class P04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int totalMin = hours * 60 + minutes + 30;
        int finalHours = totalMin / 60;
        int finalMin = totalMin % 60;
        if (finalHours >= 24) {
            finalHours -= 24;
        }
        System.out.printf("%d:%02d", finalHours, finalMin);
    }
}

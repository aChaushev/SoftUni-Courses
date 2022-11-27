package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E04_Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSteps = 0;
        boolean goingHome = false;
        while (totalSteps < 10000) {
            String input = scanner.nextLine();
            if (input.equals("Going home")) {
                int steps = Integer.parseInt(scanner.nextLine());
                totalSteps += steps;
                goingHome = true;
                break;
            }
            int steps = Integer.parseInt(input);
            totalSteps += steps;
        }

        int diff = Math.abs(totalSteps - 10000);
        if (goingHome && totalSteps < 10000) {
            System.out.printf("%d more steps to reach goal.",diff);
        } else {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", diff);
        }
    }
}

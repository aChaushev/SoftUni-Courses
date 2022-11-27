package _05_WhileLoop.MoreExercise;

import java.util.Scanner;

public class E01_Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Брой бутилки от препарат, който ще бъде използван за миенето на чинии - цяло число в интервала [1…10]
        int detergentBottlesNum = Integer.parseInt(scanner.nextLine());
        int totalDetergentInMl = detergentBottlesNum * 750;
        String input = scanner.nextLine();

        int washCounter = 0;
        int cleanDishesCounter = 0;
        int cleanPotsCounter = 0;
        boolean notEnoughDetergent = false;
        while (!input.equals("End")) {
            int currentKitchenware = Integer.parseInt(input);
            washCounter++;
            if (washCounter % 3 == 0) {
                totalDetergentInMl -= currentKitchenware * 15;
                cleanPotsCounter += currentKitchenware;
            } else {
                totalDetergentInMl -= currentKitchenware * 5;
                cleanDishesCounter += currentKitchenware;
            }
            if (totalDetergentInMl < 0) {
                notEnoughDetergent = true;
                break;
            }
            input = scanner.nextLine();
        }
        if (notEnoughDetergent) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(totalDetergentInMl));
        } else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", cleanDishesCounter, cleanPotsCounter);
            System.out.printf("Leftover detergent %d ml.", totalDetergentInMl);
        }
    }
}

package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E09_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Първи ред – начало на интервала – цяло число в интервала [1...999]
        //•	Втори ред – край на интервала – цяло число в интервала [по-голямо от първото число...1000]
        //•	Трети ред – магическото число – цяло число в интервала [1...10000]
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        int combinationCounter = 0;
        for (int i = firstNum; i <= secondNum; i++) {
            for (int j = firstNum; j <= secondNum; j++) {
                combinationCounter++;
                if (i + j == magicNum) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", combinationCounter, i, j, magicNum);
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        if (!isFound) {
            System.out.printf("%d combinations - neither equals %d", combinationCounter, magicNum);
        }
    }
}

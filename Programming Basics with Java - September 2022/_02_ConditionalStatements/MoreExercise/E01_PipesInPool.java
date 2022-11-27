package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E01_PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolCapacityV = Integer.parseInt(scanner.nextLine());
        int firstPipeP1 = Integer.parseInt(scanner.nextLine());
        int secondPipeP2 = Integer.parseInt(scanner.nextLine());
        double timeAwayH = Double.parseDouble(scanner.nextLine());

        double fillP1 = firstPipeP1 * timeAwayH;
        double fillP2 = secondPipeP2 * timeAwayH;
        double totalP1P2 = fillP1 + fillP2;

        if (totalP1P2 <= poolCapacityV) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%."
                    , totalP1P2 / poolCapacityV * 100, fillP1 / totalP1P2 * 100,
                    fillP2 / totalP1P2 * 100);
        } else {
            double hoursFulfill = totalP1P2 - poolCapacityV;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.",
                    totalP1P2 / (firstPipeP1 + secondPipeP2), hoursFulfill);
        }
    }
}

package ExamPreparations._17_JavaAdvancedExam_22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(caffeineStack::push);

        Deque<Integer> energyDrinkQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(energyDrinkQueue::offer);

        int totalCaffeine = 0;

        while (!caffeineStack.isEmpty() && !energyDrinkQueue.isEmpty()) {
            int currentCaffeine = caffeineStack.peek();
            int currentEnergyDrink = energyDrinkQueue.peek();
            int multiplied = currentCaffeine * currentEnergyDrink;
            if (multiplied + totalCaffeine <= 300) {
                totalCaffeine += multiplied;
                energyDrinkQueue.poll();
            } else {
                if (totalCaffeine < 30) {
                    totalCaffeine = 0;
                } else {
                    totalCaffeine -= 30;
                }
                energyDrinkQueue.offer(energyDrinkQueue.poll());
            }
            caffeineStack.pop();
        }

        if (energyDrinkQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.print("Drinks left: ");
            System.out.println(energyDrinkQueue.stream().
                    map(Object::toString).
                    collect(Collectors.joining(", ")).toString());
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.\n", totalCaffeine);
    }
}

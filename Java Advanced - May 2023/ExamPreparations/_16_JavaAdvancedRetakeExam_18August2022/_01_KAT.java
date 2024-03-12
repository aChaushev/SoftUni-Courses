package ExamPreparations._16_JavaAdvancedRetakeExam_18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> licensePlatesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> licensePlatesQueue.offer(e));


        Deque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> carsStack.push(e));

        int days = 0;
        int registeredCars = 0;


        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {
            days++;
            int currentLicensePlates = licensePlatesQueue.poll();
            int currentCars = carsStack.pop();

            int carsThatCanBeRegistered = currentLicensePlates / 2;

            if (carsThatCanBeRegistered > currentCars) {
                registeredCars += currentCars;
                licensePlatesQueue.offer((carsThatCanBeRegistered - currentCars) * 2);

            } else if (carsThatCanBeRegistered < currentCars) {
                registeredCars += carsThatCanBeRegistered;
                carsStack.addLast(currentCars - carsThatCanBeRegistered);
            } else {
                registeredCars += currentCars;
            }

        }
        System.out.printf("%d cars were registered for %d days!\n", registeredCars, days);
        if (!carsStack.isEmpty()) {
            System.out.println(carsStack.stream().
                    mapToInt(Integer::intValue)
                    .sum()
                    + " cars remain without license plates!");
        } else if (!licensePlatesQueue.isEmpty()) {
            System.out.println(licensePlatesQueue.stream()
                    .mapToInt(Integer::intValue)
                    .sum()
                    + " license plates remain!");
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}

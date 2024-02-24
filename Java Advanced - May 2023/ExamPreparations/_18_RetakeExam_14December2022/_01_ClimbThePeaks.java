package ExamPreparations._18_RetakeExam_14December2022;

import java.util.*;

public class _01_ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stackFoodPortions = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackFoodPortions::push);

        Deque<Integer> queueStamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queueStamina::offer);

        Deque<String> peaksToConquer = new ArrayDeque<>();
        peaksToConquer.offer("Vihren,80");
        peaksToConquer.offer("Kutelo,90");
        peaksToConquer.offer("Banski Suhodol,100");
        peaksToConquer.offer("Polezhan,60");
        peaksToConquer.offer("Kamenitza,70");

        Deque<String> conqueredPeaks = new ArrayDeque<>();

        boolean allPeaksClimbed = false;
        for (int days = 1; days <= 7; days++) {
            int dalyFoodPortion = stackFoodPortions.peek();
            int dailyStamina = queueStamina.peek();
            String currentPeak = peaksToConquer.peek();

            int sum = dalyFoodPortion + dailyStamina;
            String currentPeakName = currentPeak.split(",")[0];
            int currentPeakLevel = Integer.parseInt(currentPeak.split(",")[1]);

            if (sum >= currentPeakLevel) {
                conqueredPeaks.offer(currentPeakName);
                peaksToConquer.poll();
            }

            if (peaksToConquer.isEmpty()) {
                allPeaksClimbed = true;
                break;
            }

            stackFoodPortions.pop();
            queueStamina.poll();
        }

        if (allPeaksClimbed) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach(System.out::println);
        }


    }
}


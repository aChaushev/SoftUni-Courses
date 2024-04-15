package ExamPreparations._19_JavaAdvancedExam_18February2023;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Map.Entry.comparingByValue;

public class _01_ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //textiles queue
        //medicaments stack

        Deque<Integer> textileQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textileQueue::offer);

        Deque<Integer> medicamentStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicamentStack::push);

//        "Patch", 30
//        "Bandage", 40
//        "MedKit", 100

        Map<String, Integer> itemsObtained = new TreeMap<>();

        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()) {

            int firstTextile = textileQueue.poll();
            int lastMedicament = medicamentStack.pop();
            int sum = firstTextile + lastMedicament;
            if (sum == 30) {
                itemsObtained.putIfAbsent("Patch", 0);
                itemsObtained.put("Patch", itemsObtained.get("Patch") + 1);

            } else if (sum == 40) {
                itemsObtained.putIfAbsent("Bandage", 0);
                itemsObtained.put("Bandage", itemsObtained.get("Bandage") + 1);

            } else if (sum >= 100) {
                itemsObtained.putIfAbsent("MedKit", 0);
                itemsObtained.put("MedKit", itemsObtained.get("MedKit") + 1);
                if (sum > 100) {
                    medicamentStack.push(medicamentStack.pop() + sum - 100);
                }

            } else {
                medicamentStack.push(lastMedicament + 10);
            }
        }

        if (textileQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        itemsObtained.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue()))
                .forEach(entry ->
                        System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));

        if (!textileQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.println(textileQueue.stream().
                    map(Object::toString).
                    collect(Collectors.joining(", ")));
        } else if (!medicamentStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.println(medicamentStack.stream().
                    map(Object::toString).
                    collect(Collectors.joining(", ")));
        }

    }

}

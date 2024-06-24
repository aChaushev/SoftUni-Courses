package ExamPreparations._04_JavaAdvancedExam_28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bombEffectsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(bombEffectsQueue::offer);

        Deque<Integer> bombCasingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(bombCasingsStack::push);

        //•	Datura Bombs: 40
        //•	Cherry Bombs: 60
        //•	Smoke Decoy Bombs: 120
        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        while (!bombEffectsQueue.isEmpty() && !bombCasingsStack.isEmpty()) {

            int firstBombEffect = bombEffectsQueue.peek();
            int lastBombCasing = bombCasingsStack.peek();
            int sum = firstBombEffect + lastBombCasing;

            if (sum == 40) {
                increaseBombType(bombs, "Datura Bombs");
                removeBothMaterials(bombEffectsQueue, bombCasingsStack);

            } else if (sum == 60) {
                increaseBombType(bombs, "Cherry Bombs");
                removeBothMaterials(bombEffectsQueue, bombCasingsStack);

            } else if (sum == 120) {
                increaseBombType(bombs, "Smoke Decoy Bombs");
                removeBothMaterials(bombEffectsQueue, bombCasingsStack);

            } else {
                bombCasingsStack.push(bombCasingsStack.pop() - 5);
            }

            if (bombPouchFilled(bombs)) {
                break;
            }
        }

        if (bombPouchFilled(bombs)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        printBombMaterialsLeft(bombEffectsQueue, "Bomb Effects: ");
        printBombMaterialsLeft(bombCasingsStack, "Bomb Casings: ");

        bombs.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static void printBombMaterialsLeft(Deque<Integer> bombMaterials, String prefix) {
        System.out.print(prefix);
        if (bombMaterials.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(bombMaterials.stream().
                    map(Object::toString).
                    collect(Collectors.joining(", ")));
        }
    }

    private static boolean bombPouchFilled(Map<String, Integer> bombs) {
        return bombs.get("Datura Bombs") >= 3
                && bombs.get("Cherry Bombs") >= 3
                && bombs.get("Smoke Decoy Bombs") >= 3;
    }

    private static void increaseBombType(Map<String, Integer> bombs, String prefix) {
        bombs.put(prefix, bombs.get(prefix) + 1);
    }

    private static void removeBothMaterials(Deque<Integer> bombEffectsQueue, Deque<Integer> bombCasingsStack) {
        bombEffectsQueue.poll();
        bombCasingsStack.pop();
    }
}

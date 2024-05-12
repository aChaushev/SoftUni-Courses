package ExamPreparations._06_JavaAdvancedRetakeExam_16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        //Bread	25
        //Cake	50
        //Pastry	75
        //Fruit Pie	100
        Map<String, Integer> foodCooked = new TreeMap<>();
        foodCooked.put("Bread", 0);
        foodCooked.put("Cake", 0);
        foodCooked.put("Pastry", 0);
        foodCooked.put("Fruit Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int firstLiquid = liquidsQueue.poll();
            int lastIngredient = ingredientsStack.pop();
            int sum = firstLiquid + lastIngredient;

            if (sum == 25) {
                foodCooked.put("Bread", foodCooked.get("Bread") + 1);

            } else if (sum == 50) {
                foodCooked.put("Cake", foodCooked.get("Cake") + 1);

            } else if (sum == 75) {
                foodCooked.put("Pastry", foodCooked.get("Pastry") + 1);

            } else if (sum == 100) {
                foodCooked.put("Fruit Pie", foodCooked.get("Fruit Pie") + 1);

            } else {
                ingredientsStack.push(lastIngredient + 3);
            }
        }

        if (foodCooked.get("Bread") > 0 && foodCooked.get("Cake") > 0
                && foodCooked.get("Pastry") > 0 && foodCooked.get("Fruit Pie") > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        printMaterialsLeft(liquidsQueue,"Liquids left: ");
        printMaterialsLeft(ingredientsStack,"Ingredients left: ");

        foodCooked.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));

    }
    private static void printMaterialsLeft(Deque<Integer> materials, String prefix) {
        System.out.print(prefix);
        if (materials.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(materials.stream().
                    map(Object::toString).
                    collect(Collectors.joining(", ")));
        }
    }
}

package _06_Encapsulation_Exercise._04_PizzaCalories_ENUM;

import _06_Encapsulation_Exercise._04_PizzaCalories.Dough;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        String[] doughInfo = scanner.nextLine().split("\\s+");
        String doughName = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weightInGrams = Double.parseDouble(doughInfo[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(doughName, bakingTechnique, weightInGrams);
            pizza.setDough(dough);

            String command = scanner.nextLine();
            while (!"END".equals(command)) {
                String[] toppingInfo = command.split("\\s+");
                String toppingName = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping = new Topping(toppingName, toppingWeight);
                pizza.addTopping(topping);

                command = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%n",pizza.getName(),pizza.getOverallCalories());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }



    }
}

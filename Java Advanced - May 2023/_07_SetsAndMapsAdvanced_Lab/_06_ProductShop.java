package _07_SetsAndMapsAdvanced_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shopsMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] info = input.split(", ");

            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            shopsMap.putIfAbsent(shop, new LinkedHashMap<>());

            Map<String, Double> productsMap = shopsMap.get(shop);

            productsMap.putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        shopsMap.forEach((shop, products) -> {
            System.out.printf("%s->\n", shop);
            products.forEach((product, price) ->
                    System.out.printf("Product: %s, Price: %.1f\n", product, price));
        });
    }
}

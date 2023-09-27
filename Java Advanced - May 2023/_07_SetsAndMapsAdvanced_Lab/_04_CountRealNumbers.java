package _07_SetsAndMapsAdvanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        for (double realNum : input) {

            if (!numbersMap.containsKey(realNum)) {
                numbersMap.put(realNum, 1);
            } else {
                numbersMap.put(realNum, numbersMap.get(realNum) + 1);
            }
        }

        numbersMap.forEach((key, value) ->
                System.out.printf("%.1f -> %d\n",key,value));

    }
}

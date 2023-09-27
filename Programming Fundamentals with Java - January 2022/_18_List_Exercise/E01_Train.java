package _18_List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacityOfWagon = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            if (input.contains("Add")) {
                int passengersToAdd = Integer.parseInt(input.split(" ")[1]);
                numbersList.add(passengersToAdd);
            } else {
                int passengersToFit = Integer.parseInt(input);
                for (int i = 0; i < numbersList.size(); i++) {
                    if (numbersList.get(i) + passengersToFit <= maxCapacityOfWagon) {
                        numbersList.set(i, numbersList.get(i) + passengersToFit);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }
        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}

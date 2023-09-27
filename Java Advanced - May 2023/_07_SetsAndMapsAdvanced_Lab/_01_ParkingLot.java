package _07_SetsAndMapsAdvanced_Lab;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingSet = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] info = input.split(", ");
            String command = info[0];
            String regNum = info[1];

            if (command.equals("IN")) {
                parkingSet.add(regNum);
            } else if (command.equals("OUT")) {
                parkingSet.remove(regNum);
            }

            input = scanner.nextLine();
        }

        String output = parkingSet.isEmpty()
                ? "Parking Lot is Empty"
                : String.join(System.lineSeparator(), parkingSet);

        System.out.println(output);
    }
}

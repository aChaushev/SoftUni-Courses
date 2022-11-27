package PreliminaryExam_21_22Oct;

import java.util.Scanner;

public class E03_CourierExpress_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double shipmentWeightKg = Double.parseDouble(scanner.nextLine());
        boolean expressService = scanner.nextLine().equals("express");
        int distanceKm = Integer.parseInt(scanner.nextLine());

        double finalPrice = 0;

        if (shipmentWeightKg < 1) {
            finalPrice = distanceKm * 0.03;
            if (expressService) {
                finalPrice += distanceKm * shipmentWeightKg * 0.03 * 0.8;
            }
        } else if (shipmentWeightKg < 10) {
            finalPrice = distanceKm * 0.05;
            if (expressService) {
                finalPrice += distanceKm * shipmentWeightKg * 0.05 * 0.4;
            }
        } else if (shipmentWeightKg < 40) {
            finalPrice = distanceKm * 0.10;
            if (expressService) {
                finalPrice += distanceKm * shipmentWeightKg * 0.10 * 0.05;
            }
        } else if (shipmentWeightKg < 90) {
            finalPrice = distanceKm * 0.15;
            if (expressService) {
                finalPrice += distanceKm * shipmentWeightKg * 0.15 * 0.02;
            }
        } else if (shipmentWeightKg < 150) {
            finalPrice = distanceKm * 0.20;
            if (expressService) {
                finalPrice += distanceKm * shipmentWeightKg * 0.20 * 0.01;
            }
        }
        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", shipmentWeightKg, finalPrice);
    }
}

package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E04_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nKm = Integer.parseInt(scanner.nextLine());
        String dayNight = scanner.nextLine();

        double taxiDay = 0.70 + 0.79 * nKm;
        double taxiNight = 0.70 + 0.90 * nKm;
        double bus = 0.09 * nKm;
        double train = 0.06 * nKm;

        if (nKm < 20) {
            if (dayNight.equals("day")) {
                System.out.printf("%.2f", taxiDay);
            } else if (dayNight.equals("night")) {
                System.out.printf("%.2f", taxiNight);
            }
        } else if (nKm < 100) {
            if (dayNight.equals("day")) {
                if (taxiDay < bus) {
                    System.out.printf("%.2f", taxiDay);
                } else if (bus <= taxiDay) {
                    System.out.printf("%.2f", bus);
                }
            } else if (dayNight.equals("night")) {
                if (taxiNight < bus) {
                    System.out.printf("%.2f", taxiNight);
                } else if (bus <= taxiNight) {
                    System.out.printf("%.2f", bus);
                }
            }
        } else {
            if (dayNight.equals("day")) {
                if ((taxiDay < bus && taxiDay < train) || (taxiDay == bus && taxiDay < train) || (taxiDay == train && taxiDay < bus)) {
                    System.out.printf("%.2f", taxiDay);
                } else if ((bus < taxiDay && bus < train) || (bus == taxiDay && bus < train) || (bus == train && bus < taxiDay)) {
                    System.out.printf("%.2f", bus);
                } else if (train < taxiDay && train < bus) {
                    System.out.printf("%.2f", train);
                }

            } else if (dayNight.equals("night")) {
                if ((taxiNight < bus && taxiNight < train) || (taxiNight == bus && taxiNight < train) || (taxiNight == train && taxiNight < bus)) {
                    System.out.printf("%.2f", taxiNight);
                } else if ((bus < taxiNight && bus < train) || (bus == taxiNight && bus < train) || (bus == train && bus < taxiNight)) {
                    System.out.printf("%.2f", bus);
                } else if (train < taxiNight && train < bus) {
                    System.out.printf("%.2f", train);
                }
            }
        }
    }
}

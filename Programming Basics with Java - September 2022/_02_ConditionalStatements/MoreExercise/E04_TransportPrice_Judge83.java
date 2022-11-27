package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E04_TransportPrice_Judge83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nKm = Integer.parseInt(scanner.nextLine());
        String dayNight = scanner.nextLine();

        double taxi = 0.70;
        double bus = 0.09;
        double train = 0.06;

        if (nKm < 20 && dayNight.equals("day")) {
            taxi = taxi + nKm * 0.79;
            System.out.printf("%.2f", taxi);
        } else if (nKm < 20 && dayNight.equals("night")) {
            taxi = taxi + nKm * 0.90;
            System.out.printf("%.2f", taxi);
        } else if (nKm < 100 && dayNight.equals("day")) {
            taxi = taxi + nKm * 0.79;
            bus = bus * nKm;
            if (taxi < bus) {
                System.out.printf("%.2f", taxi);
            } else if (taxi > bus) {
                System.out.printf("%.2f", bus);
            }
        } else if (nKm < 100 && dayNight.equals("night")) {
            taxi = taxi + nKm * 0.90;
            bus = bus * nKm;
            if (taxi < bus) {
                System.out.printf("%.2f", taxi);
            } else if (taxi > bus) {
                System.out.printf("%.2f", bus);
            }
        } else if (nKm > 100 && dayNight.equals("day")) {
            taxi = taxi + nKm * 0.79;
            bus = bus * nKm;
            train = train * nKm;
            if (taxi < bus && taxi < train) {
                System.out.printf("%.2f", taxi);
            } else if (bus < taxi && bus < train) {
                System.out.printf("%.2f", bus);
            } else if (train < taxi && train < bus) {
                System.out.printf("%.2f", train);
            }
        } else if (nKm > 100 && dayNight.equals("night")) {
            taxi = taxi + nKm * 0.90;
            bus = bus * nKm;
            train = train * nKm;
            if (taxi < bus && taxi < train) {
                System.out.printf("%.2f", taxi);
            } else if (bus < taxi && bus < train) {
                System.out.printf("%.2f", bus);
            } else if (train < taxi && train < bus) {
                System.out.printf("%.2f", train);
            }
        }
    }
}

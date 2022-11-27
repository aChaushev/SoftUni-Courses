package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E07_FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int fansNum = Integer.parseInt(scanner.nextLine());

        double sectorA = 0;
        double sectorB = 0;
        double sectorV = 0;
        double sectorG = 0;
        for (int i = 1; i <= fansNum; i++) {
            String sector = scanner.nextLine();
            switch (sector) {
                case "A":
                    sectorA++;
                    break;
                case "B":
                    sectorB++;
                    break;
                case "V":
                    sectorV++;
                    break;
                case "G":
                    sectorG++;
                    break;
            }
        }
        System.out.printf("%.2f%%%n", sectorA / fansNum * 100);
        System.out.printf("%.2f%%%n", sectorB / fansNum * 100);
        System.out.printf("%.2f%%%n", sectorV / fansNum * 100);
        System.out.printf("%.2f%%%n", sectorG / fansNum * 100);
        System.out.printf("%.2f%%%n", fansNum * 1.0 / stadiumCapacity * 100);
    }
}

package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E01_PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.	Първи ред – брой на хората. Цяло число в интервала [1…100]
        //2.	Втори ред – такса вход. Реално число в интервала [0.00…50.00]
        //3.	Трети ред – цена един за шезлонг. Реално число в интервала [0.00…50.00]
        //4.	Четвърти ред – цена за един чадър. Реално число в интервала [0.00...50.00]
        int peopleNum = Integer.parseInt(scanner.nextLine());
        double entrancePrice = Double.parseDouble(scanner.nextLine());
        double sunbedPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double totalEntrancePrice = entrancePrice * peopleNum;
        double totalSunbedPrice = sunbedPrice * Math.ceil(peopleNum * 0.75);
        double totalUmbrellaPrice = umbrellaPrice * Math.ceil(peopleNum * 1.0 / 2);

        double totalSum = totalEntrancePrice + totalSunbedPrice + totalUmbrellaPrice;
        System.out.printf("%.2f lv.", totalSum);

    }
}

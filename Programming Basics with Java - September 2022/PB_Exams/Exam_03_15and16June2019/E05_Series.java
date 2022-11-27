package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E05_Series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int seriesNum = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;
        for (int i = 1; i <= seriesNum; i++) {
            String seriesName = scanner.nextLine();
            double seriesPrice = Double.parseDouble(scanner.nextLine());
            switch (seriesName) {
                case "Thrones":
                    seriesPrice -= seriesPrice * 0.5;
                    break;
                case "Lucifer":
                    seriesPrice -= seriesPrice * 0.4;
                    break;
                case "Protector":
                    seriesPrice -= seriesPrice * 0.3;
                    break;
                case "TotalDrama":
                    seriesPrice -= seriesPrice * 0.2;
                    break;
                case "Area":
                    seriesPrice -= seriesPrice * 0.1;
                    break;
            }
            totalPrice += seriesPrice;
        }
        double diff = Math.abs(budget - totalPrice);
        if (budget >= totalPrice) {
            System.out.printf("You bought all the series and left with %.2f lv.", diff);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", diff);
        }
    }
}

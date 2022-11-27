package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E04_Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	На първия ред – желаната печалба на клуба - реално число в интервала [1.00... 15000.00]
        //Поредица от два реда до получаване на командата "Party!" или до достигане на желаната печалба:
        //o	Име на коктейла – текст
        //o	Брой на коктейлите за поръчката – цяло число в интервала [1… 50]
        double targetProfit = Double.parseDouble(scanner.nextLine());
        String cocktailName = scanner.nextLine();

        double sum = 0;
        boolean targetAcquired = false;
        while (!cocktailName.equals("Party!")) {
            int cocktailNum = Integer.parseInt(scanner.nextLine());
            double cocktailPrice = cocktailName.length() * cocktailNum;
            if (cocktailPrice % 2 != 0) {
                cocktailPrice -= cocktailPrice * 0.25;
            }

            sum += cocktailPrice;
            if (sum >= targetProfit) {
                targetAcquired = true;
                break;
            }
            cocktailName = scanner.nextLine();
        }

        if (targetAcquired) {
            System.out.println("Target acquired.");
        } else {
            System.out.printf("We need %.2f leva more.%n", targetProfit - sum);
        }
        System.out.printf("Club income - %.2f leva.", sum);
    }
}

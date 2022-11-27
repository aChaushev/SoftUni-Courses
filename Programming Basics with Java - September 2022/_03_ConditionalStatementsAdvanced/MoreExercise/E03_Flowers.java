package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E03_Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	На първия ред е броят на закупените хризантеми – цяло число в интервала [0 ... 200]
        //•	На втория ред е броят на закупените рози – цяло число в интервала [0 ... 200]
        //•	На третия ред е броят на закупените лалета – цяло число в интервала [0 ... 200]
        //•	На четвъртия ред е посочен сезона – [Spring, Summer, Аutumn, Winter]
        //•	На петия ред е посочено дали денят е празник – [Y – да / N - не]

        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        char holidayOrNot = scanner.nextLine().charAt(0);
        //Сезон	        Хризантеми	    Рози	        Лалета
        //Пролет / Лято	2.00 лв./бр.	4.10 лв./бр.	2.50 лв./бр.
        //Есен / Зима	3.75 лв./бр.	4.50 лв./бр.	4.15 лв./бр.

        double bouquetPrice = 0;

        if (season.equals("Spring") || season.equals("Summer")) {
            if (holidayOrNot == 'N') {
                bouquetPrice = chrysanthemums * 2 + roses * 4.1 + tulips * 2.5;
            } else if (holidayOrNot == 'Y') {
                bouquetPrice = chrysanthemums * (2 + 2 * 0.15) + roses * (4.1 + 4.1 * 0.15) + tulips * (2.5 + 2.5 * 0.15);
            }
        } else if (season.equals("Autumn") || season.equals("Winter")) {
            if (holidayOrNot == 'N') {
                bouquetPrice = chrysanthemums * 3.75 + roses * 4.5 + tulips * 4.15;
            } else if (holidayOrNot == 'Y') {
                bouquetPrice = chrysanthemums * (3.75 + 3.75 * 0.15) + roses * (4.5 + 4.5 * 0.15) + tulips * (4.15 + 4.15 * 0.15);
            }
        }

        if (season.equals("Spring") && tulips > 7) {
            bouquetPrice -= bouquetPrice * 0.05;
        } else if (season.equals("Winter") && roses >= 10) {
            bouquetPrice -= bouquetPrice * 0.1;
        }

        if ((chrysanthemums + roses + tulips) > 20) {
            bouquetPrice -= bouquetPrice * 0.2;
        }
        bouquetPrice += 2;
        System.out.printf("%.2f", bouquetPrice);
    }
}

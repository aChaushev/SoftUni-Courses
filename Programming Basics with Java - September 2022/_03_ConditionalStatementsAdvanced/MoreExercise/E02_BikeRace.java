package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E02_BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първият ред – броят младши велосипедисти. Цяло число в интервала [1…100]
        //•	Вторият ред – броят старши велосипедисти. Цяло число в интервала [1… 100]
        //•	Третият ред – вид трасе – "trail", "cross-country", "downhill" или "road"
        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine();

        //Група	    trail	cross-country	downhill	road
        //juniors	5.50	8	            12.25	    20
        //seniors	7	    9.50	        13.75	    21.50

        double totalFee = 0;
        if (trackType.equals("trail")) {
            totalFee = juniors * 5.50 + seniors * 7;
        } else if (trackType.equals("cross-country")) {
            totalFee = juniors * 8 + seniors * 9.50;
            if ((juniors + seniors) >= 50) {
                totalFee -= totalFee * 0.25;
            }
        } else if (trackType.equals("downhill")) {
            totalFee = juniors * 12.25 + seniors * 13.75;
        } else if (trackType.equals("road")) {
            totalFee = juniors * 20 + seniors * 21.50;
        }
        totalFee -= totalFee * 0.05;
        System.out.printf("%.2f", totalFee);
    }
}

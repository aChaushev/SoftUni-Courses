package _03_ConditionalStatementsAdvanced.Book;

import java.util.Scanner;

public class B12_Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //• Първият ред съдържа думата "leap" (високосна година) или "normal" (нормал-на година с 365 дни).
        //• Вторият ред съдържа цялото число p – брой празници в годината (които не са събота или неделя).
        //• Третият ред съдържа цялото число h – брой уикенди, в които Влади си пътува до родния град.
        String year = scanner.nextLine().toLowerCase();
        int holidaysP = Integer.parseInt(scanner.nextLine());
        int weekendsH = Integer.parseInt(scanner.nextLine());

        double volleyPlay = 3 / 4.0 * (48 - weekendsH) + 2 / 3.0 * holidaysP + weekendsH;
        if (year.equals("leap")) {
            volleyPlay += volleyPlay * 0.15;
        }
        System.out.printf("%.0f", Math.floor(volleyPlay));
    }
}

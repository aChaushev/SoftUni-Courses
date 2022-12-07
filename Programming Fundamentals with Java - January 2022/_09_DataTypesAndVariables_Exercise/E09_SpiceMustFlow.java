package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int dayCnt = 0;
        int extractedSpice = 0;
        while (yield >= 100) {
            extractedSpice += yield - 26;
            yield -= 10;
            dayCnt++;
            if (yield < 100) {
                extractedSpice -= 26;
            }
        }
        System.out.println(dayCnt);
        System.out.println(extractedSpice);
    }
}

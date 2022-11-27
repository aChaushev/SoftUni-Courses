package _01_FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class E03_DepositCalculator {
    public static void main(String[] srgs){
        Scanner scanner = new Scanner(System.in);

        double deposits = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        //сума = депозирана сума  + срок на депозита * ((депозирана сума * годишен лихвен процент ) / 12)
        double sum = deposits + months * ((deposits * percent * 0.01)/12);

        System.out.println(sum);
    }
}

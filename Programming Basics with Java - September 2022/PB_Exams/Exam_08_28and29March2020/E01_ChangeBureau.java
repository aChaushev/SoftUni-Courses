package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E01_ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoinCnt = Integer.parseInt(scanner.nextLine());
        double chineseYuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double sumInBGN = bitcoinCnt * 1168 + chineseYuan * 0.15 * 1.76;
        double sumInEuro = sumInBGN / 1.95;
        double finalSumEuro = sumInEuro - sumInEuro * commission / 100;
        System.out.printf("%.2f", finalSumEuro);
    }
}

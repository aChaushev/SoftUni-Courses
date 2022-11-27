package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E01_TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tennisRacketPrice = Double.parseDouble(scanner.nextLine());
        int tennisRacketCnt = Integer.parseInt(scanner.nextLine());
        int sneakersCnt = Integer.parseInt(scanner.nextLine());

        double sneakersPrice = tennisRacketPrice / 6;
        double totalPrice = tennisRacketPrice * tennisRacketCnt + sneakersPrice * sneakersCnt;
        totalPrice *= 1.2;
        System.out.printf("Price to be paid by Djokovic %.0f%n", Math.floor(totalPrice / 8));
        System.out.printf("Price to be paid by sponsors %.0f", Math.ceil(totalPrice * 7 / 8));
    }
}

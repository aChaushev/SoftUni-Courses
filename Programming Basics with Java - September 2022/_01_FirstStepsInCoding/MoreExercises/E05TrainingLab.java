package _01_FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class E05TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wM = Double.parseDouble(scanner.nextLine());
        double hM = Double.parseDouble(scanner.nextLine());

        double w = wM * 100;
        double h = hM * 100 - 100;
        double widthDesk = (h - (h % 70)) / 70;
        double lengthDesk = (w - (w % 120)) / 120;
        double AllDesks = widthDesk * lengthDesk - 3;
        System.out.printf("%.0f", AllDesks);
    }
}

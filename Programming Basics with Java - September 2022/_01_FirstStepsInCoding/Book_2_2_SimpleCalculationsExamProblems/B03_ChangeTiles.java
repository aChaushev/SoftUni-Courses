package _01_FirstStepsInCoding.Book_2_2_SimpleCalculationsExamProblems;

import java.util.Scanner;

public class B03_ChangeTiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double playgroundN = Double.parseDouble(scanner.nextLine());
        double tileW = Double.parseDouble(scanner.nextLine());
        double tileL = Double.parseDouble(scanner.nextLine());
        double benchM = Double.parseDouble(scanner.nextLine());
        double benchO = Double.parseDouble(scanner.nextLine());

        double playgroundArea = playgroundN * playgroundN - benchM * benchO;
        double tileArea = tileL * tileW;
        double tileCount = playgroundArea / tileArea;
        double workTime = tileCount * 0.2;
        System.out.println(tileCount);
        System.out.println(workTime);
    }
}

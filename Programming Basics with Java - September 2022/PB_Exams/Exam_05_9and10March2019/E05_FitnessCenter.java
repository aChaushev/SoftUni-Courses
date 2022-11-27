package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E05_FitnessCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int visitorsNum = Integer.parseInt(scanner.nextLine());

        int trainingBack = 0;
        int trainingChest = 0;
        int trainingLegs = 0;
        int trainingAbs = 0;
        int purchasedProteinShake = 0;
        int purchasedProteinBar = 0;
        for (int i = 1; i <= visitorsNum; i++) {
            String type = scanner.nextLine();
            switch (type) {
                case "Back":
                    trainingBack++;
                    break;
                case "Chest":
                    trainingChest++;
                    break;
                case "Legs":
                    trainingLegs++;
                    break;
                case "Abs":
                    trainingAbs++;
                    break;
                case "Protein shake":
                    purchasedProteinShake++;
                    break;
                case "Protein bar":
                    purchasedProteinBar++;
                    break;
            }
        }
        int allPeopleTraining = trainingBack + trainingChest + trainingLegs + trainingAbs;
        int allPeopleProtein = purchasedProteinShake + purchasedProteinBar;
        System.out.printf("%d - back%n", trainingBack);
        System.out.printf("%d - chest%n", trainingChest);
        System.out.printf("%d - legs%n", trainingLegs);
        System.out.printf("%d - abs%n", trainingAbs);
        System.out.printf("%d - protein shake%n", purchasedProteinShake);
        System.out.printf("%d - protein bar%n", purchasedProteinBar);
        System.out.printf("%.2f%% - work out%n", allPeopleTraining * 1.0 / visitorsNum * 100);
        System.out.printf("%.2f%% - protein%n", allPeopleProtein * 1.0 / visitorsNum * 100);
    }
}

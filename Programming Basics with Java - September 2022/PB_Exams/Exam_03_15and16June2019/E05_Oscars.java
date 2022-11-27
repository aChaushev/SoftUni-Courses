package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E05_Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        double allPoints = academyPoints;
        for (int i = 1; i <= n; i++) {
            String currentName = scanner.nextLine();
            double currentPoints = Double.parseDouble(scanner.nextLine());
            allPoints += currentName.length() * currentPoints / 2;
            if (allPoints > 1250.5) {
                break;
            }
        }
        if (allPoints > 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, allPoints);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - allPoints);
        }
    }
}

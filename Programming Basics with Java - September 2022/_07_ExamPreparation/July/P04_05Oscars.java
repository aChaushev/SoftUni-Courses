package _07_ExamPreparation.July;

import java.util.Scanner;

public class P04_05Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //• Име на актьора – текст
        //• Точки от академията - реално число в интервала [2.0... 450.5]
        //• Брой оценяващи n – цяло число в интервала[1… 20]
        String actorsName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int jury = Integer.parseInt(scanner.nextLine());

        boolean gotNominee = false;
        double totalActorPoints = academyPoints;
        for (int i = 1; i <= jury; i++) {
            String name = scanner.nextLine();
            double points = Double.parseDouble(scanner.nextLine());
            int nameLength = name.length();
            double pointSum = (nameLength * points) / 2;

            totalActorPoints += pointSum;

            if (totalActorPoints > 1250.5) {
                gotNominee = true;
                break;
            }
        }
        if (gotNominee) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorsName, totalActorPoints);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actorsName, 1250.5 - totalActorPoints);
        }
    }
}

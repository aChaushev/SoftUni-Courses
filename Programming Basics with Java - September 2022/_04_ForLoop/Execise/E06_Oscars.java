package _04_ForLoop.Execise;

import java.util.Scanner;

public class E06_Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Име на актьора - текст
        //•	Точки от академията - реално число в интервала [2.0... 450.5]
        //•	Брой оценяващи n - цяло число в интервала[1… 20]
        //На следващите n-на брой реда:
        //o	Име на оценяващия - текст
        //o	Точки от оценяващия - реално число в интервала [1.0... 50.0]

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String currentAppraiser = scanner.nextLine();
            double appraiserPoints = Double.parseDouble(scanner.nextLine());

            academyPoints += (currentAppraiser.length() * appraiserPoints) / 2;

            if (academyPoints >= 1250.5) {
                break;
            }
        }
        if (academyPoints >= 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!",
                    actorName, academyPoints);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!",
                    actorName, 1250.5 - academyPoints);
        }
    }
}

package _04_ForLoop.Execise;

import java.util.Scanner;

public class E05_Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Брой отворени табове в браузъра n - цяло число в интервала [1...10]
        //•	Заплата - число в интервала [500...1500]

        //•	Ако по време на проверката заплатата стане по-малка или равна на 0 лева, на конзолата се изписва
        //"You have lost your salary." и програмата приключва.
        //•	В противен случай след проверката на конзолата се изписва остатъкът от заплатата (да се изпише като цяло число).

        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        //•	"Facebook" -> 150 лв.
        //•	"Instagram" -> 100 лв.
        //•	"Reddit" -> 50 лв.

        for (int i = 1; i <= n; i++) {
            String currentSite = scanner.nextLine();
            if (currentSite.equals("Facebook")) {
                salary -= 150;
            } else if (currentSite.equals("Instagram")) {
                salary -= 100;
            } else if (currentSite.equals("Reddit")) {
                salary -= 50;
            }
            if (salary <= 0) {
                break; // i = n + 1;
            }

        }
        if (salary > 0) {
            System.out.println(salary);
        } else {
            System.out.println("You have lost your salary.");
        }
    }
}

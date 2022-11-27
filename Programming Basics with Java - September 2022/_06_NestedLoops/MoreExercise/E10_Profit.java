package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E10_Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.	Брой монети по 1лв. - цяло положително число;
        //2.	Брой монети по 2лв. - цяло положително число;
        //3.	Брой банкноти по 5лв. - цяло положително число;
        //4.	Сума - цяло положително число в интервала [1…1000];
        int oneLvCoins = Integer.parseInt(scanner.nextLine());
        int twoLvCoins = Integer.parseInt(scanner.nextLine());
        int fiveLvCoins = Integer.parseInt(scanner.nextLine());
        int targetSum = Integer.parseInt(scanner.nextLine());

        for (int lv1 = 0; lv1 <= oneLvCoins; lv1++) {
            for (int lv2 = 0; lv2 <= twoLvCoins * 2; lv2 += 2) {
                for (int lv5 = 0; lv5 <= fiveLvCoins * 5; lv5 += 5) {
                    if (lv1 + lv2 + lv5 == targetSum) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", lv1, lv2 / 2, lv5 / 5, targetSum);
                    }
                }
            }
        }
    }
}

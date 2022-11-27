package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P11_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCnt = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        // int headsetCnt = lostGamesCnt / 2;
        // int mouseCnt = lostGamesCnt / 3;
        // int keyboardCnt = lostGamesCnt / 6;
        // int displayCnt = lostGamesCnt / 12;
        // double totalPrice = (headsetCnt * headsetPrice) + ....;

        double totalPrice = 0;
        int keyboardTrashCnt = 0;
        for (int i = 1; i <= lostGamesCnt; i++) {
            if (i % 2 == 0) {
                totalPrice += headsetPrice;
            }
            if (i % 3 == 0) {
                totalPrice += mousePrice;
            }

            if (i % 2 == 0 && i % 3 == 0) {
                totalPrice += keyboardPrice;
                keyboardTrashCnt++;
            }
            if (keyboardTrashCnt > 0 && keyboardTrashCnt % 2 == 0) {
                totalPrice += displayPrice;
                keyboardTrashCnt = 0;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", totalPrice);
    }
}

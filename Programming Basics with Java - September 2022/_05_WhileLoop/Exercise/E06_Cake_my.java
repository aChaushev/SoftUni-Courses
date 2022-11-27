package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E06_Cake_my {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        //int allPeaces = 0;
        int cakePeaces = width * length;
        boolean enoughPeaces = false;
        while (cakePeaces > 0) {
            String input = scanner.nextLine();
            if (input.equals("STOP")) {
                enoughPeaces = true;
                break;
            } else {
                int peaces = Integer.parseInt(input);
                //        allPeaces +=peaces;
                cakePeaces -= peaces;
            }
        }
        if (enoughPeaces && cakePeaces >= 0) {
            System.out.printf("%d pieces are left.", cakePeaces);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.",Math.abs(cakePeaces));
        }
    }
}

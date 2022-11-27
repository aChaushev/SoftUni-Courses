package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E06_Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());


        int cakePeaces = width * length;
        String input = scanner.nextLine();
        boolean noMoreCake = false;
        while (!input.equals("STOP")) {
            int peaces = Integer.parseInt(input);
            cakePeaces -= peaces;

            if (cakePeaces <= 0) {
                noMoreCake = true;
                break;
            }

            input = scanner.nextLine();
        }
        if (noMoreCake) {
            System.out.printf("No more cake left! You need %d pieces more.",Math.abs(cakePeaces));
        } else {
            System.out.printf("%d pieces are left.", cakePeaces);
        }
    }
}

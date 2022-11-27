package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E07_Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int apartmentCapacity = width * length * height;

        String input = scanner.nextLine();
        boolean notEnoughSpace = false;
        while (!input.equals("Done")) {
            int packages = Integer.parseInt(input);
            apartmentCapacity -= packages;

            if (apartmentCapacity < 0) {
                notEnoughSpace = true;
                break;
            }
            input = scanner.nextLine();
        }

        if (notEnoughSpace) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(apartmentCapacity));
        } else {
            System.out.printf("%d Cubic meters left.", apartmentCapacity);
        }
    }
}

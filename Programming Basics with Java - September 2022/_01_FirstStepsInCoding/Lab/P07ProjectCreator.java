package _01_FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P07ProjectCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String archName = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());

        int hours = projects * 3;

        System.out.printf("The architect %s will need %d hours to complete " +
                "%d project/s.", archName, hours, projects);
    }

}

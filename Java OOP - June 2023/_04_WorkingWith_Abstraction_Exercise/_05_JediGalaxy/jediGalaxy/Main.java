package _04_WorkingWith_Abstraction_Exercise._05_JediGalaxy.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read matrix
        // coordinates of player
        // coordinates of evil
        // fill matrix
        int[] dimensions = readPositions(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        Field field = new Field(rows, cols);
        String command = scanner.nextLine();
        long starsCount = 0;

        while (!command.equals("Let the Force be with you")) {

            Jedi jedi = new Jedi(Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray());
            EvilPower evilPower = new EvilPower(readPositions(scanner));

            Galaxy galaxy = new Galaxy(field, jedi, evilPower);

            galaxy.moveEvil();

            starsCount += galaxy.moveJedi();

            command = scanner.nextLine();
        }

        System.out.println(starsCount);

    }

    private static int[] readPositions(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

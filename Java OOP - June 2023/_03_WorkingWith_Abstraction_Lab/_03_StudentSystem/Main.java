package _03_WorkingWith_Abstraction_Lab._03_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String[] input = readInputSaveToArray(scanner);

        while (!input[0].equals("Exit")) {

            studentSystem.parseCommand(input);

            input = readInputSaveToArray(scanner);
        }
    }

    private static String[] readInputSaveToArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}

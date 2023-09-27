package _18_List_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = new ArrayList<>();
        int commandsNum = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= commandsNum; i++) {
            String command = scanner.nextLine();
            if (command.contains("is going")) {
                if (namesList.contains(command.split("\\s+")[0])) {
                    System.out.println(command.split("\\s+")[0] + " is already in the list!");
                } else {
                    namesList.add(command.split("\\s+")[0]);
                }
            } else if (command.contains("is not going")) {
                if (namesList.contains(command.split("\\s+")[0])) {
                    namesList.remove(command.split("\\s+")[0]);
                } else {
                    System.out.println(command.split("\\s+")[0] + " is not in the list!");
                }
            }
        }
        for (String name : namesList) {
            System.out.println(name);
        }
    }
}

package _18_List_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08_AnonymousThreat_HARD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputLine = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            if (command.contains("merge")) {
                int startIndex = Integer.parseInt(command.split("\\s+")[1]);
                int endIndex = Integer.parseInt(command.split("\\s+")[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > inputLine.size() - 1) {
                    endIndex = inputLine.size() - 1;
                }
                if (startIndex > inputLine.size() - 1 || endIndex < 0) {
                    command = scanner.nextLine();
                    continue;
                }
                String concatenatedElement = "";
                for (int i = startIndex; i <= endIndex; i++) {
                    concatenatedElement += inputLine.get(i);
                }
                inputLine.set(startIndex, concatenatedElement);
                for (int i = endIndex; i > startIndex; i--) {
                    inputLine.remove(i);
                }

            } else if (command.contains("divide")) {
                int index = Integer.parseInt(command.split("\\s+")[1]);
                int partitions = Integer.parseInt(command.split("\\s+")[2]);
                if (partitions == 0) {
                    command = scanner.nextLine();
                    continue;
                }
                // divide 4 5
                List<String> dividedString = new ArrayList<>();
                String currentElement = inputLine.get(index); // qrstuvwxyz // 10
                int subStringLength = currentElement.length() / partitions; //10/5=2
                int count = 0;
                String separatedElement = "";
                int counterAdded = 0;

                for (int i = 0; i < currentElement.length(); i++) {

                    char symbol = currentElement.charAt(i);
                    separatedElement += symbol;
                    count++;

                    if (count == subStringLength && counterAdded < partitions) {
                        dividedString.add(separatedElement);
                        separatedElement = "";
                        count = 0;
                        counterAdded++;

                    }
                }
                String lastElementDividedString = dividedString.get(dividedString.size() - 1);
                dividedString.set(dividedString.size() - 1, lastElementDividedString + separatedElement); //добавяме остатъка към последния поделемент, в случаите когато и ма остътък при делението
                inputLine.remove(index);

                for (int i = dividedString.size() - 1; i >= 0; i--) {
                    inputLine.add(index, dividedString.get(i));
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(inputLine.toString().replaceAll("[\\[\\],]", ""));
    }
}

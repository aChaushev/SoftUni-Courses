package _17_List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String lineInput = scanner.nextLine();
        while (!lineInput.equals("end")) {
            String[] commandArr = lineInput.split(" ");
            String command = commandArr[0];

            switch (command) {
                case "Contains":
                    int numContains = Integer.parseInt(commandArr[1]);
                    if (numbersList.contains(numContains)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (commandArr[1].equals("even")) {
                        for (int element : numbersList) {
                            if (element % 2 == 0) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    } else if (commandArr[1].equals("odd")) {
                        for (int element : numbersList) {
                            if (element % 2 != 0) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int element : numbersList) {
                        sum += element;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    int numFilter = Integer.parseInt(commandArr[2]);
                    if (commandArr[1].equals("<")) {
                        for (int element : numbersList) {
                            if (element < numFilter) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    } else if (commandArr[1].equals(">")) {
                        for (int element : numbersList) {
                            if (element > numFilter) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    } else if (commandArr[1].equals(">=")) {
                        for (int element : numbersList) {
                            if (element >= numFilter) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    } else if (commandArr[1].equals("<=")) {
                        for (int element : numbersList) {
                            if (element <= numFilter) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    }

                    break;
            }
            lineInput = scanner.nextLine();
        }
    }
}

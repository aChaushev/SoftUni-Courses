package _12_Arrays_Exercise;

import java.util.Scanner;

public class E10_TreasureHunt_X80 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lootArr = scanner.nextLine().split("\\|");

        String[] commandArr = scanner.nextLine().split(" ");
        while (!commandArr[0].equals("Yohoho!")) {
            if (commandArr[0].equals("Loot")) {
                for (int i = 1; i < commandArr.length; i++) {
                    boolean alreadyContained = false;
                    for (int j = 0; j < lootArr.length; j++) {
                        if (lootArr[j].equals(commandArr[i])) {
                            alreadyContained = true;
                            break;
                        }
                    }
                    if (!alreadyContained) {
                        String newCommandArr = commandArr[i] + " " + String.join(" ", lootArr);
                        lootArr = newCommandArr.split(" ");
                    }
                }
            }
            if (commandArr[0].equals("Drop")) {
                int index = Integer.parseInt(commandArr[1]);
                if (index < lootArr.length && index >= 0) {
                    String dropItem = lootArr[index];
                    for (int i = index; i < lootArr.length - 1; i++) {
                        lootArr[i] = lootArr[i + 1];
                    }
                    lootArr[lootArr.length - 1] = dropItem;
                }
            }
            if (commandArr[0].equals("Steal")) {
                int itemsCnt = Integer.parseInt(commandArr[1]);
                for (int i = lootArr.length - itemsCnt; i < lootArr.length; i++) {
                    if (i < lootArr.length - 1) {
                        System.out.printf("%s, ", lootArr[i]);
                    } else {
                        System.out.printf("%s", lootArr[i]);
                    }
                    if (i == lootArr.length - 1) {
                        System.out.printf("%n");
                    }
                }
                String[] newCommandArr = new String[lootArr.length - itemsCnt];
                for (int i = 0; i < lootArr.length - itemsCnt; i++) {
                    newCommandArr[i] = lootArr[i];
                }
                lootArr = newCommandArr;
            }
            commandArr = scanner.nextLine().split(" ");
        }

        if (lootArr.length == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            int elementsLengthSum = 0;
            for (String element : lootArr) {
                elementsLengthSum += element.length();
            }
            double averageGain = elementsLengthSum * 1.0 / lootArr.length;
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }
}

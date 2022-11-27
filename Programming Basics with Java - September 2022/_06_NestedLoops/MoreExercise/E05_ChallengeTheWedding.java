package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E05_ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Броя клиенти мъже - цяло число в интервала [1...100]
        //•	Броя клиенти жени - цяло число в интервала [1...100]
        //•	Максималният брой маси - цяло число в интервала [1...100]
        int men = Integer.parseInt(scanner.nextLine());
        int women = Integer.parseInt(scanner.nextLine());
        int tables = Integer.parseInt(scanner.nextLine());

        int seatingCounter = 0;
        for (int i = 1; i <= men; i++) {
            for (int j = 1; j <= women; j++) {
                if (seatingCounter >= tables){
                    break;
                }
                    System.out.printf("(%d <-> %d) ", i, j);
                seatingCounter++;
            }

            if (seatingCounter >= tables){
                break;
            }

        }
    }
}

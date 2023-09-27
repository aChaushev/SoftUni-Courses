package _03_WorkingWith_Abstraction_Lab._02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = pointCoordinates[0];
        int bottomLeftY = pointCoordinates[1];
        int topRightX = pointCoordinates[2];
        int topRightY = pointCoordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int pointsCnt = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= pointsCnt; i++) {
            int[] checkPontCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int checkPointX = checkPontCoordinates[0];
            int checkPointY = checkPontCoordinates[1];

            Point targetPoint = new Point(checkPointX, checkPointY);

            System.out.println(rectangle.contains(targetPoint));

        }
    }
}

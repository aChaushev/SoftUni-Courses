package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E04_Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Височина на стената - цяло число [0… 100]
        //2. Ширина на стената - цяло число [0… 100]
        //3. Процент от общата площ на стените, който няма да бъде боядисан - цяло число [5… 95]
        // На следващите редове до получаване на командата "Tired!" или докато не бъдат боядисани всички стени,
        // се чете по едно число:
        //• Литри боя – цяло число [0…100]:
        //Забележка: Площта за боядисване да бъде закръглена нагоре до най-близкото цяло число.
        int wallHeight = Integer.parseInt(scanner.nextLine());
        int wallWidth = Integer.parseInt(scanner.nextLine());
        int notPaintedPercent = Integer.parseInt(scanner.nextLine());

        double allWalls = Math.ceil(wallHeight * wallWidth * 4);
        double areaForPaint = allWalls - allWalls * (notPaintedPercent * 1.0 / 100);

        String command = scanner.nextLine();
        double paintedWalls = 0;
        while (!command.equals("Tired!")) {
            int currentPaintArea = Integer.parseInt(command);
            paintedWalls += currentPaintArea;

            if (paintedWalls >= areaForPaint) {
                break;
            }
            command = scanner.nextLine();
        }
        double diff = Math.abs(paintedWalls - areaForPaint);
        if (command.equals("Tired!")) {
            System.out.printf("%.0f quadratic m left.", diff);
        } else if (paintedWalls > areaForPaint) {
            System.out.printf("All walls are painted and you have %.0f l paint left!", diff);
        } else if (paintedWalls == areaForPaint) {
            System.out.println("All walls are painted! Great job, Pesho!");
        }
    }
}

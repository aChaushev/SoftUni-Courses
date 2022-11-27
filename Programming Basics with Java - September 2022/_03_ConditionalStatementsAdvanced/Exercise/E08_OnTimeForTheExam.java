package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E08_OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първият ред съдържа час на изпита – цяло число от 0 до 23.
        //•	Вторият ред съдържа минута на изпита – цяло число от 0 до 59.
        //•	Третият ред съдържа час на пристигане – цяло число от 0 до 23.
        //•	Четвъртият ред съдържа минута на пристигане – цяло число от 0 до 59.

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examBeginning = examHour * 60 + examMinute;
        int arrivalTime = arrivalHour * 60 + arrivalMinute;


        int diffTime = Math.abs(arrivalTime - examBeginning);
        int hh = diffTime / 60;
        int mm = diffTime % 60;
        if (arrivalTime > examBeginning) {
            System.out.println("Late");
            if (diffTime >= 60) {
                    System.out.printf("%d:%02d hours after the start", hh, mm);
            } else {
                System.out.printf("%d minutes after the start", mm);
            }
        } else if (examBeginning == arrivalHour || diffTime <= 30) {  //((examBeginning - 30) <= arrivalTime && arrivalTime <= examBeginning)
            System.out.println("On time");
            if (diffTime >=1 && diffTime <=30){
                System.out.printf("%d minutes before the start", mm);
            }
        } else if (diffTime > 30) { //(arrivalTime < (examBeginning - 30))
            System.out.println("Early");
            if (diffTime < 60) {
                System.out.printf("%d minutes before the start", mm);
            } else {
                System.out.printf("%d:%02d hours before the start", hh, mm);
            }
        }


//        if ((examBeginning - 60) < arrivalTime && arrivalTime < examBeginning) {
//            System.out.printf("%d minutes before the start", mm);
//        } else if (arrivalTime <= (examBeginning - 60)) {
//            if (mm < 10) {
//                System.out.printf("%d:0%d hours before the start", hh, mm);
//            } else {
//                System.out.printf("%d:%d hours before the start", hh, mm);
//            }
//        } else if (examBeginning < arrivalTime && arrivalTime < (examBeginning + 60)) {
//            System.out.printf("%d minutes after the start", mm);
//        } else if ((examBeginning + 60) <= arrivalTime) {
//            if (mm < 10) {
//                System.out.printf("%d:0%d hours after the start", hh, mm);
//            } else {
//                System.out.printf("%d:%d hours after the start", hh, mm);
//            }
    }
}


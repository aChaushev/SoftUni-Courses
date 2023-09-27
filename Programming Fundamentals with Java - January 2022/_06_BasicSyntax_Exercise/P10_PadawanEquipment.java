package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	The amount of money George Lucas has – the floating-point number in the range [0.00…1,000.00].
        //•	The count of students – integer in the range [0…100].
        //•	The price of lightsabers for a single saber – the floating-point number in the range [0.00…100.00].
        //•	The price of robes for a single robe – the floating-point number in the range [0.00…100.00].
        //•	The price of belts for a single belt – the floating-point number in the range [0.00…100.00].

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCnt = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        //double totalPrice = ((studentsCnt + Math.ceil(studentsCnt * 0.1)) * lightsaberPrice) + (studentsCnt * robePrice)
        //        + ((studentsCnt - (studentsCnt / 6)) * beltPrice);
        double totalSabers = (studentsCnt + Math.ceil(studentsCnt * 0.1)) * lightsaberPrice;
        double totalRobes = studentsCnt * robePrice;
        double totalBelts = (studentsCnt - (studentsCnt / 6)) * beltPrice;
        double totalPrice = totalSabers + totalRobes + totalBelts;

        if (budget >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - budget);
        }
    }
}

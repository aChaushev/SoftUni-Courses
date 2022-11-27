package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E02_Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	На първия ред – периода, за който трябва да направите изчисления. Цяло число в интервала [1 ... 1000]
        //•	На следващите редове(равни на броят на дните)
        // – броя пациенти, които пристигат за преглед за текущия ден. Цяло число в интервала [0…10 000]
        int inputDays = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;
        for (int i = 1; i <= inputDays; i++) {
            if (i % 3 == 0) {
                if (untreatedPatients > treatedPatients) {
                    doctors++;
                }
            }
            int patientsPerDay = Integer.parseInt(scanner.nextLine());
            if (patientsPerDay < doctors) {
                treatedPatients += patientsPerDay;
            } else {
                treatedPatients += doctors;
                untreatedPatients += patientsPerDay - doctors;
            }
        }
        System.out.printf("Treated patients: %d.%n", treatedPatients);
        System.out.printf("Untreated patients: %d.%n", untreatedPatients);
    }
}

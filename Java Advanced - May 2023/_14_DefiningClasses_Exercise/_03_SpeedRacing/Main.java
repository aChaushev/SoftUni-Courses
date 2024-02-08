package _14_DefiningClasses_Exercise._03_SpeedRacing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carsMap = new LinkedHashMap<>();
        // запис: модел на колята (уникален) -> обект кола

        for (int i = 0; i < countCars; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Integer.parseInt(data[1]);
            double fuelCostPerKm = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            carsMap.put(model,car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")){
            //"Drive {CarModel} {amountOfKm}"
            String carModel = command.split("\\s+")[1];
            int amountOfKm = Integer.parseInt(command.split("\\s+")[2]);

            //взимам коя кола ще карам
            Car carToDrive = carsMap.get(carModel);

            // ако няма достатъчно гориво за шофиране
            if(!carToDrive.drive(amountOfKm)){
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }

        // print "{Model} {fuelAmount} {distanceTraveled}"
        for(Car car : carsMap.values()){
            System.out.println(car.toString());
        }

    }
}


package _14_DefiningClasses_Exercise._04_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Car>> carsByCargoTypeMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Engine engine = new Engine(engineSpeed,enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);
//            double tire1Pressure = Double.parseDouble(data[5]);
//            int tire1Age = Integer.parseInt(data[6]);
//            double tire2Pressure = Double.parseDouble(data[7]);
//            int tire2Age = Integer.parseInt(data[8]);
//            double tire3Pressure = Double.parseDouble(data[9]);
//            int tire3Age = Integer.parseInt(data[10]);
//            double tire4Pressure = Double.parseDouble(data[11]);
//            int tire4Age = Integer.parseInt(data[12]);
            List<Tire> tiresPressure = new ArrayList<>();
            for (int j = 5; j <= 12; j += 2) {
                Tire trie = new Tire(Double.parseDouble(data[j]), Integer.parseInt(data[j + 1]));
                tiresPressure.add(trie);
            }
            Car currentCar = new Car(model,engine,cargo,tiresPressure);
            carsByCargoTypeMap.putIfAbsent(cargoType,new ArrayList<>());
            carsByCargoTypeMap.get(cargoType).add(currentCar);

        }

        String command = scanner.nextLine();

        carsByCargoTypeMap.get(command).forEach(car -> car.extractCar(command));


    }
}

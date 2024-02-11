package _14_DefiningClasses_Exercise._05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //"{Model} {Power} {Displacement} {Efficiency}"
            // required: model, power
            // optional: displacement, efficiency
            String[] engineData = scanner.nextLine().split("\\s+");
            // required:
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            // optional:
            int displacement = 0;
            String efficiency = null;

            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];
                }
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engineList.add(engine);

        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            //"{Model} {Engine} {Weight} {Color}"
            String[] carData = scanner.nextLine().split("\\s+");
            // required:
            String model = carData[0];
            String engineModel = carData[1];
            // optional:
            int weight = 0;
            String color = null;

            if (carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    weight = Integer.parseInt(carData[2]);
                } else {
                    color = carData[2];
                }
            }

            Engine carEngine = null;
            for(Engine engine : engineList){
                if(engineModel.equals(engine.getModel())){
                    carEngine = engine;
                    break;
                }
            }

            Car car = new Car(model,carEngine,weight,color);
            System.out.print(car.toString());
        }
    }
}

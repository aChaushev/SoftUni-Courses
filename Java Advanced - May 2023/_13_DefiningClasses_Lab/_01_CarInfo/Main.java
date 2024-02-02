package _13_DefiningClasses_Lab._01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0){
            String[] data = scanner.nextLine().split("\\s+");

//            Car car = data.length == 1
//                    ? new Car(data[0])
//                    : new Car(data[0], data[1], Integer.parseInt(data[2]));
            Car car;
            if(data.length == 1){
                car = new Car(data[0]);
            } else {
                car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            }
            cars.add(car);

        }
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

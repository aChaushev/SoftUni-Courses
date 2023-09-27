package _09_InterfacesAndAbstraction_Lab._05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");

            Identifiable identifiable;

            if (data.length == 3) {

                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];

                identifiable = new Citizen(name, age, id);

            } else {
                String model = data[0];
                String id = data[1];

                identifiable = new Robot(model, id);

            }

            identifiableList.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeIdPostfix = scanner.nextLine();

        identifiableList.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIdPostfix))
                .forEach(System.out::println);

    }
}

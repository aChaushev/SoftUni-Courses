package _14_DefiningClasses_Exercise._07_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Person> personsMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];

            personsMap.putIfAbsent(name, new Person());

//•	"{Name} company {companyName} {department} {salary}"
//•	"{Name} pokemon {pokemonName} {pokemonType}"
//•	"{Name} parents {parentName} {parentBirthday}"
//•	"{Name} children {childName} {childBirthday}"
//•	"{Name} car {carModel} {carSpeed}"
            if (data[1].equals("company")) {
                String companyName = data[2];
                String department = data[3];
                double salary = Double.parseDouble(data[4]);
                Company company = new Company(companyName, department, salary);
                personsMap.get(name).setCompany(company);

            } else if (data[1].equals("pokemon")) {
                String pokemonName = data[2];
                String pokemonType = data[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                personsMap.get(name).getPokemons().add(pokemon);

            } else if (data[1].equals("parents")) {
                String parentName = data[2];
                String parentBirthday = data[3];
                Parent parent = new Parent(parentName, parentBirthday);
                personsMap.get(name).getParents().add(parent);

            } else if (data[1].equals("children")) {
                String childName = data[2];
                String childBirthday = data[3];
                Child child = new Child(childName, childBirthday);
                personsMap.get(name).getChildren().add(child);

            } else if (data[1].equals("car")) {
                String carModel = data[2];
                int carSpeed = Integer.parseInt(data[3]);
                Car car = new Car(carModel, carSpeed);
                personsMap.get(name).setCar(car);
            }


            input = scanner.nextLine();
        }
        String personToPrint = scanner.nextLine();
        System.out.println(personToPrint);
        System.out.println(personsMap.get(personToPrint));

    }
}

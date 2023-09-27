package _08_Inheritance_Exercise._06_Animals;

import _08_Inheritance_Exercise._06_Animals.animals.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!"Beast!".equals(animalType)) {

            String[] animalInfo = scanner.nextLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            try {

                switch (animalType) {
                    case "_11_Polymorphism_Lab._03_Animals.Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "_11_Polymorphism_Lab._03_Animals.Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            animalType = scanner.nextLine();
        }

    }
}

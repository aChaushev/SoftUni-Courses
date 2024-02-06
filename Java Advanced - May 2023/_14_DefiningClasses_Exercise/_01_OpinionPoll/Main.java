package _14_DefiningClasses_Exercise._01_OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            personList.add(person);

        }

        personList.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(person -> person.getName()))
                .forEach(person -> System.out.printf("%s - %d\n", person.getName(), person.getAge()));

    }
}

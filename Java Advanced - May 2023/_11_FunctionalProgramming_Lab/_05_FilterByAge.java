package _11_FunctionalProgramming_Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _05_FilterByAge {

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> readPerson = sc -> {
            String[] data = sc.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            return new Person(name, age);
        };


        List<Person> people = IntStream.range(0, n)
                .mapToObj(i -> readPerson.apply(scanner)) // използвай скенера чрез функцията readPerson
                .collect(Collectors.toList()); // запази резултата в List-а

//        или
//
//        List<Person> people = new ArrayList<>();
//
//        while (n-- > 0){
//            Person p = readPerson.apply(scanner);
//            people.add(p);
//        }

        // прочети останалия input
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        // заяви Predicate и Consumer с input class Person използвайки методи ageFilter и getPrinter
        Predicate<Person> ageFilter = getFilter(condition, age);
        Consumer<Person> printer = getPrinter(format);

        // използвай горепосочените в за да stream-неш по List-a people
        // , като го филтрираш с Predicate и да го изпринтираш с Consumer
        people.stream()
                .filter(ageFilter)
                .forEach(printer);

    }

    private static Consumer<Person> getPrinter(String format) throws IllegalAccessException {
        switch (format) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalAccessException("Unknown print format " + format);
        }
    }

    private static Predicate<Person> getFilter(String condition, int age) throws IllegalAccessException {
        switch (condition) {
            case "older":
                return p -> p.age >= age;

            case "younger":
                return p -> p.age <= age;

            default:
                throw new IllegalAccessException("Unknown condition " + condition);
        }
    }
}

package _14_DefiningClasses_Exercise._02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departmentsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            //mandatory
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            String email = "n/a";
            int age = -1;

            //optional
            if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);
            } else if (data.length == 5) {
                if (data[4].contains("@")) {
                    email = data[4];
                } else {
                    age = Integer.parseInt(data[4]);
                }
            }

            Employee employee = new Employee(name, salary, position, department, email, age);
            departmentsMap.putIfAbsent(department,new Department(department));

            departmentsMap.get(department).getEmployeeList().add(employee);

        }

        Department maxAverageSalaryDepartment = departmentsMap
                .entrySet()
                .stream()
                .max(Comparator.comparing(d -> d.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployeeList().stream()
                .sorted(((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())))
                .forEach(employee -> System.out.println(employee.toString()));


    }
}

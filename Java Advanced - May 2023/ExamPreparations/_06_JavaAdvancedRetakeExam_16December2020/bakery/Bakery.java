package ExamPreparations._06_JavaAdvancedRetakeExam_16December2020.bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
//        return data.stream()
//                .max(Comparator.comparing(Employee::getAge))
//                .get();
        return Collections.max(employees, (f, s) -> f.getAge() - s.getAge());
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(this.name).append(":");
        for (Employee employee : employees) {
            sb.append(System.lineSeparator());
            sb.append(employee.toString());
        }
        return sb.toString();
    }

}

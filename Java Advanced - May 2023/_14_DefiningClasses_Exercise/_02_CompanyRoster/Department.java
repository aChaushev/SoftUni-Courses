package _14_DefiningClasses_Exercise._02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    //average salary
    public double getAverageSalary(){
        return employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0);
    }

}

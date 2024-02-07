package _14_DefiningClasses_Exercise._02_CompanyRoster;

public class Employee {
    //name, salary, position, department, email, age.
    //mandatory
    private String name;
    private double salary;
    private String position;
    private String department;
    //optional
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        //{name1} {salary1} {email1} {age1}
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_2_AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //add new address
        String newAddress = "Vitoshka 15";
        Address address = new Address();
        address.setText(newAddress);
        entityManager.persist(address);

        //select Employee by lastName
        Scanner scanner = new Scanner(System.in);
        String EmployeeLastName = scanner.nextLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e" +
                                " WHERE e.lastName = :name"
                        , Employee.class)
                .setParameter("name", EmployeeLastName)
                .getSingleResult();

        //set new address to Employee
        employee.setAddress(address);

        //update changes to database
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

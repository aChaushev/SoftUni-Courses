import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_1_AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //add new address
        String newAddressText = "Vitoshka 15";
        Address address = new Address();
        address.setText(newAddressText);
        entityManager.persist(address);

        //update Employee address by lastName
        Scanner scanner = new Scanner(System.in);
        String EmployeeLastName = scanner.nextLine();

        entityManager
                .createQuery("UPDATE Employee e" +
                                " SET e.address = :address" +
                                " WHERE e.lastName = :name")
                .setParameter("name", EmployeeLastName)
                .setParameter("address", address)
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

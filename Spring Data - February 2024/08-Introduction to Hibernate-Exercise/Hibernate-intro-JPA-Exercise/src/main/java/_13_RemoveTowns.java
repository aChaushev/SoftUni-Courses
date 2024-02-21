import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _13_RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String inputTown = scanner.nextLine();

        Town townToDelete = entityManager.createQuery("FROM Town t " +
                        "WHERE t.name = :town", Town.class)
                .setParameter("town", inputTown)
                .getSingleResult();

        List<Address> addressesToDelete = entityManager.createQuery("FROM Address a " +
                        "WHERE a.town.name = :town", Address.class)
                .setParameter("town", inputTown)
                .getResultList();

        addressesToDelete.forEach(a -> a.getEmployees()
                            .forEach(e -> e.setAddress(null)));

        addressesToDelete.forEach(address -> entityManager.remove(address));
        entityManager.remove(townToDelete);

        int countDeletedAddresses = addressesToDelete.size();

        System.out.printf("%d address%s in %s deleted",
                countDeletedAddresses,
                countDeletedAddresses == 1 ? "" : "es",
                inputTown);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

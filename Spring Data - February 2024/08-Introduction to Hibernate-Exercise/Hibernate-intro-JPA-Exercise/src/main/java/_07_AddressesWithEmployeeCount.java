import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class _07_AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager
                .createQuery("FROM Address a" +
                                " ORDER BY a.employees.size DESC"
                                ,Address.class)
                .setMaxResults(10) // -> преминава през толкова, колкото са му зададени
                .getResultStream()
                // .limit(10 ) -> преминава през цалата база
                .forEach(a -> {
                    System.out.printf("%s, %s - %d employees\n",
                    a.getText(),
                    a.getTown() == null ? "": a.getTown().getName(),
                    a.getEmployees().size());
                });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

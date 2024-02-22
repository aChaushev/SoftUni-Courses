import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String[] searchedName = scanner.nextLine().split(" ");

        Long employeeCnt = entityManager
                .createQuery("SELECT COUNT(e) FROM Employee e " +
                                " WHERE e.firstName = :first_name" +
                                " AND e.lastName = :last_name",
                        Long.class)
                .setParameter("first_name", searchedName[0])
                .setParameter("last_name", searchedName[1])
                .getSingleResult();

        if (employeeCnt > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

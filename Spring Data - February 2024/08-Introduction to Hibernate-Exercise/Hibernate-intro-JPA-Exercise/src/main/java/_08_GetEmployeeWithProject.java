import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class _08_GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int inputId = Integer.parseInt(scanner.nextLine());

        entityManager.createQuery(" FROM Employee e " +
                                        " WHERE e.id = :id" +
                                        " ORDER BY CONCAT(e.firstName, e.lastName)", Employee.class)
                            .setParameter("id",inputId)
                            .getResultStream()
                            .forEach(e ->{
                                System.out.printf("%s %s - %s\n",
                                        e.getFirstName(),
                                        e.getLastName(),
                                        e.getJobTitle());
                                e.getProjects()
                                        .stream()
                                        .map(Project::getName)
                                        .sorted()
                                        .forEach(System.out::println);
                            });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

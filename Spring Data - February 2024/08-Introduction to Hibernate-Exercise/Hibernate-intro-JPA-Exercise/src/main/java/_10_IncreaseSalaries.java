import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<String> departNames = new ArrayList<>();
        departNames.add("Engineering");
        departNames.add("Tool Design");
        departNames.add("Marketing");
        departNames.add("Information Services ");

        List<Employee> resultList =
                entityManager.createQuery("FROM Employee e " +
                        " WHERE e.department.name IN :departList", Employee.class)
                .setParameter("departList", departNames)
                .getResultList();

        for (Employee employee : resultList) {
            BigDecimal salary = employee.getSalary();
            employee.setSalary(salary.multiply(BigDecimal.valueOf(1.12)));
            System.out.printf("%s %s ($%.2f)\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

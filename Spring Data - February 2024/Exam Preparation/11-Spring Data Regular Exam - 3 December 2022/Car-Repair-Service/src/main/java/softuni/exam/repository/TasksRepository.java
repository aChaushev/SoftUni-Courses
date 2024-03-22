package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.CarType;
import softuni.exam.models.entity.Task;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {


    @Query("SELECT t FROM Task t" +
            " JOIN t.car c" +
            " WHERE c.carType =:targetCarType" +
            " ORDER BY t.price DESC")
    List<Task> findTaskByCar_CarType_CoupeAndOrderByPriceDesc(CarType targetCarType);
}

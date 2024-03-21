package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;

import java.util.List;
import java.util.Optional;

// TODO:
@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findByDayOfWeek(DayOfWeek dayOfWeek);

    Optional<Forecast> findByDayOfWeekAndCity(DayOfWeek dayOfWeek, City city);

    List<Forecast> findByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek dayOfWeek,
                                                                                    int targetPopulation);
}

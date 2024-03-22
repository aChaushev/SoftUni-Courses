package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Country;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {


    Optional<Country> findByNameOrCode(String name, String code);

    Optional<Country> findByName(String name);

    Optional<Country> findByCode(String code);
}

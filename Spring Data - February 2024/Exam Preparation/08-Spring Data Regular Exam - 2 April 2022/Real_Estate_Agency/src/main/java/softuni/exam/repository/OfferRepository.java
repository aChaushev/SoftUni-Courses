package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {


    Optional<Offer> findByAgent(Optional<Agent> optAgent);


    @Query("SELECT o FROM Offer o" +
            " JOIN o.apartment ap" +
            " JOIN o.agent ag" +
            " WHERE ap.apartmentType =:searchedApType" +
            " ORDER BY ap.area DESC, o.price ASC"  )
    List<Offer> findAllByApartment_ApartmentTypeOrderByApartmentDescPriceAsc(ApartmentType searchedApType);
}

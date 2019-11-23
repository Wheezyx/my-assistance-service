package pl.hackathon.myassistanceservice.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;

import java.math.BigDecimal;
import java.util.Set;

public interface AssistanceRepository extends JpaRepository<Assistance, Long> {
    Set<Assistance> findAllByLatitudeBetweenAndLongitudeBetween(double minLatitude,
                                                                double maxLatitude,
                                                                double minLongitude,
                                                                double maxLongitude);
}

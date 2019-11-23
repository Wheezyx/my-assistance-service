package pl.hackathon.myassistanceservice.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;

import java.util.Set;

public interface AssistanceRepository extends JpaRepository<Assistance, Long> {

    @Query(value = "select a from Assistance a where " +
            "a.latitude between :minLatitude and :maxLatitude " +
            "and a.longitude between :minLongitude and :maxLongitude " +
            "and a.assistanceStatus = 'ACTIVE'")
    Set<Assistance> findAssistanceInRange(double minLatitude,
                                          double maxLatitude,
                                          double minLongitude,
                                          double maxLongitude);
}

package pl.hackathon.myassistanceservice.persistance.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;

public interface AssistanceRepository extends JpaRepository<Assistance, Long> {

  @Query(value = "select a from Assistance a where " +
      "a.latitude between :minLatitude and :maxLatitude " +
      "and a.longitude between :minLongitude and :maxLongitude " +
      "and a.assistanceStatus = 'ACTIVE' or a.assistanceStatus = 'IN_PROGRESS'")
  Set<Assistance> findAssistanceInRange(double minLatitude,
      double maxLatitude,
      double minLongitude,
      double maxLongitude);

  @Query(value = "SELECT a FROM Assistance a WHERE "
      + "a.creator.id = :creatorId "
      + "AND a.assistanceStatus NOT LIKE 'COMPLETE'")
  Set<Assistance> findAllNotCompletedByCreatorId(Long creatorId);
}

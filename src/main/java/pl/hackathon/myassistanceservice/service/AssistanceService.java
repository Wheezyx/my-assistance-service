package pl.hackathon.myassistanceservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;
import pl.hackathon.myassistanceservice.persistance.repository.AssistanceRepository;

import java.math.BigDecimal;
import java.util.Set;

@Service
@AllArgsConstructor
public class AssistanceService {

    private static final double LATITUDE_DEGREE_KM = 180 / (110.574 * Math.PI);
    private static final double LONGITUDE_DEGREE_KM = 180 / (111.320 * Math.PI);

    private final AssistanceRepository assistanceRepository;

    public Set<Assistance> findAssistancesInRange(double latitude, double longitude, double range) {
        double minLatitude = latitude - LATITUDE_DEGREE_KM;
        double maxLatitude = latitude + LATITUDE_DEGREE_KM;
        double minLongitude = longitude - LONGITUDE_DEGREE_KM;
        double maxLongitude = longitude + LONGITUDE_DEGREE_KM;
        return assistanceRepository.findAllByLatitudeBetweenAndLongitudeBetween(minLatitude, maxLatitude, minLongitude, maxLongitude);
    }

    private double calculateLatitude(double range) {
        return 0; //todo: implement
    }

    private double calculateLongitude(double range) {
        return 0; //todo: implement
    }

}

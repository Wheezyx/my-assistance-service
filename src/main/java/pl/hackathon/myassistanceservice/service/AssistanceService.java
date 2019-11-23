package pl.hackathon.myassistanceservice.service;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;
import pl.hackathon.myassistanceservice.persistance.entity.User;
import pl.hackathon.myassistanceservice.persistance.repository.AssistanceRepository;
import pl.hackathon.myassistanceservice.persistance.repository.UserRepository;

@Service
@AllArgsConstructor
public class AssistanceService {

    private static final double LATITUDE_DEGREE_IN_KM = 110.574;
    private static final double LONGITUDE_DEGREE_IN_KM = 111.320;

    private final AssistanceRepository assistanceRepository;
    private final UserRepository userRepository;


    public Set<Assistance> findAssistancesInRange(double latitude, double longitude, double range) {
        double latitudeRange = calculateLatitudeRange(range);
        double longitudeRange = calculateLongitudeRange(range, latitude);
        double minLatitude = latitude - latitudeRange;
        double maxLatitude = latitude + latitudeRange;
        double minLongitude = longitude - longitudeRange;
        double maxLongitude = longitude + longitudeRange;
        return assistanceRepository
            .findAllByLatitudeBetweenAndLongitudeBetween(minLatitude, maxLatitude, minLongitude,
                maxLongitude);
    }

    private double calculateLatitudeRange(double range) {
        return (range * Math.PI) / (180 * LATITUDE_DEGREE_IN_KM);
    }

    private double calculateLongitudeRange(double range, double latitude) {
        return (range * Math.PI) / (180 * LONGITUDE_DEGREE_IN_KM * Math.cos(latitude));
    }

    public Assistance saveAssistance(Assistance assistancetoSave, Long creatorId) {
        //TODO Change runtime exception to dedicated, properly named exception and handle it
        final User creator = userRepository.findById(creatorId).orElseThrow(() ->
            new RuntimeException("Creator not found"));

        assistancetoSave.setCreator(creator);
        return assistanceRepository.save(assistancetoSave);

    }
}

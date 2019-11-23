package pl.hackathon.myassistanceservice.service;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;
import pl.hackathon.myassistanceservice.persistance.entity.User;
import pl.hackathon.myassistanceservice.persistance.enums.AssistanceStatus;
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
        double longitudeRange = calculateLongitudeRange(range);
        double minLatitude = latitude - latitudeRange;
        double maxLatitude = latitude + latitudeRange;
        double minLongitude = longitude - longitudeRange;
        double maxLongitude = longitude + longitudeRange;
        return assistanceRepository
            .findAssistanceInRange(minLatitude, maxLatitude, minLongitude, maxLongitude);
    }

    private double calculateLatitudeRange(double range) {
        return range / LATITUDE_DEGREE_IN_KM;
    }

    private double calculateLongitudeRange(double range) {
        return range / LONGITUDE_DEGREE_IN_KM;
    }

    public Assistance saveAssistance(Assistance assistanceToSave, Long creatorId) {
        //TODO Change runtime exception to dedicated, properly named exception and handle it
        final User creator = userRepository.findById(creatorId).orElseThrow(() ->
            new RuntimeException("Creator not found"));

        assistanceToSave.setCreator(creator);
        return assistanceRepository.save(assistanceToSave);

    }

    public Assistance findAssistanceById(Long id) {
        return this.assistanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Assistance not found"));
    }

    public Assistance assignAssistance(Long assistanceId, Long assistantId) {
        User assistant = userRepository.findById(assistantId).orElseThrow(() ->
            new RuntimeException("Creator not found"));

        Assistance assistance = this.findAssistanceById(assistanceId);

        if (assistance.getAssistant() != null) {
            throw new RuntimeException("Assistant is already assign.");
        }

        if (assistant.getId().equals(assistance.getCreator().getId())) {
            throw new RuntimeException(
                "You cannot assign yourself to the assistance that you've created.");
        }

        assistance.setAssistant(assistant);
        assistance.setAssistanceStatus(AssistanceStatus.IN_PROGRESS);

        return assistanceRepository.save(assistance);
    }
}

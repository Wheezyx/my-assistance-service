package pl.hackathon.myassistanceservice.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import pl.hackathon.myassistanceservice.rest.controller.ConnectionStatus;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class LocationMessage {
    private ConnectionStatus connectionStatus;
    private double assistantLatitude;
    private double assistantLongitude;

    public static LocationMessage of(PositionMessage positionMessage, ConnectionStatus status) {
        return new LocationMessage()
                .setConnectionStatus(status)
                .setAssistantLatitude(positionMessage.getAssistantLatitude())
                .setAssistantLongitude(positionMessage.getAssistantLongitude());
    }
}

package pl.hackathon.myassistanceservice.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import pl.hackathon.myassistanceservice.rest.dto.LocationMessage;
import pl.hackathon.myassistanceservice.rest.dto.PositionMessage;

@Controller
@AllArgsConstructor
public class SocketController {

    private static final double DISTANCE_BETWEEN = 0.01;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/position")
    public void sendAssistantLocationToCreator(PositionMessage message) {
        ConnectionStatus connectionStatus = ConnectionStatus.OPEN;
        if (isClose(message)) {
            connectionStatus = ConnectionStatus.CLOSE;
        }
        messagingTemplate.convertAndSendToUser(message.getCreatorId().toString(), "/location", LocationMessage.of(message, connectionStatus));
    }

    private boolean isClose(PositionMessage positionMessage) {
        return Math.abs(positionMessage.getAssistanceLatitude() - positionMessage.getAssistantLatitude()) < DISTANCE_BETWEEN &&
                Math.abs(positionMessage.getAssistanceLongitude() - positionMessage.getAssistantLongitude()) < DISTANCE_BETWEEN;
    }
}


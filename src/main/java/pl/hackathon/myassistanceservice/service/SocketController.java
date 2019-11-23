package pl.hackathon.myassistanceservice.service;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import pl.hackathon.myassistanceservice.rest.dto.LocationMessage;

@Controller
@AllArgsConstructor
public class SocketController {

  private final SimpMessagingTemplate messagingTemplate;


  @MessageMapping("/position")
  public void sendAssistantLocationToCreator(LocationMessage message) {
    messagingTemplate
        .convertAndSendToUser(String.valueOf(message.getCreatorId()), "/location", message);
  }
}

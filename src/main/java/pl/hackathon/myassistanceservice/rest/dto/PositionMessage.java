package pl.hackathon.myassistanceservice.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.hackathon.myassistanceservice.rest.controller.ConnectionStatus;

@Data
@NoArgsConstructor
public class PositionMessage {

  private double assistanceLatitude;
  private double assistanceLongitude;
  private double assistantLatitude;
  private double assistantLongitude;
  private ConnectionStatus connectionStatus;
  private Long creatorId;
}

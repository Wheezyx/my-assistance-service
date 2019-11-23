package pl.hackathon.myassistanceservice.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationMessage {

  private double latitude;
  private double longitude;
  private Long creatorId;
}

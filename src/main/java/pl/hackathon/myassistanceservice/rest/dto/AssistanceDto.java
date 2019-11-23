package pl.hackathon.myassistanceservice.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import pl.hackathon.myassistanceservice.persistance.enums.AssistanceStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AssistanceDto {

  private Long id;

  private Double latitude;

  private Double longitude;

  private Long creator;

  private Long assistant;

  private AssistanceStatus assistanceStatus;

  private String disabilityType;

  private String helpType;

}

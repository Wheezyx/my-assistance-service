package pl.hackathon.myassistanceservice.rest.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public final class UserDto {

  private Long id;
  private String username;
  private String firstName;
  private String lastName;
  private int points;
  private Set<AssistanceDto> notCompletedAssistances;
}

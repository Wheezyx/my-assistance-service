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

  private Set<AssistanceDto> notCompletedAssistances;
}

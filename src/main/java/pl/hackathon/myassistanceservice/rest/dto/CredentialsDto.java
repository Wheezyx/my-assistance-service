package pl.hackathon.myassistanceservice.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CredentialsDto {

  private String username;
  private String password;
}

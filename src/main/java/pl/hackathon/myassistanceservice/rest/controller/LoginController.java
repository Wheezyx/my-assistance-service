package pl.hackathon.myassistanceservice.rest.controller;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;
import pl.hackathon.myassistanceservice.persistance.entity.User;
import pl.hackathon.myassistanceservice.rest.dto.AssistanceDto;
import pl.hackathon.myassistanceservice.rest.dto.CredentialsDto;
import pl.hackathon.myassistanceservice.rest.dto.UserDto;
import pl.hackathon.myassistanceservice.service.AssistanceService;
import pl.hackathon.myassistanceservice.service.UserService;

@AllArgsConstructor
@RequestMapping("/login")
@RestController
public class LoginController {

  private final UserService userService;
  private final AssistanceService assistanceService;

  @PostMapping
  public UserDto login(@RequestBody CredentialsDto credentials) {
    User user = userService.findByUsername(credentials.getUsername());
    Set<AssistanceDto> notCompletedAssistances = assistanceService
        .findAllNotCompletedAssistancesByCreatorId(user.getId()).stream()
        .map(Assistance::toDto)
        .collect(Collectors.toSet());

    return UserDto.builder()
        .id(user.getId())
        .notCompletedAssistances(notCompletedAssistances)
        .build();
  }
}

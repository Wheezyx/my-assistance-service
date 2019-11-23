package pl.hackathon.myassistanceservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hackathon.myassistanceservice.persistance.entity.User;
import pl.hackathon.myassistanceservice.persistance.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User findByUsername(String username) {
    return this.userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }
}

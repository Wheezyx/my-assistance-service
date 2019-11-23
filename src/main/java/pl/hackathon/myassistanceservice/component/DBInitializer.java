package pl.hackathon.myassistanceservice.component;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.hackathon.myassistanceservice.persistance.entity.User;
import pl.hackathon.myassistanceservice.persistance.repository.UserRepository;

@Component
@AllArgsConstructor
public class DBInitializer implements CommandLineRunner {

  private final UserRepository userRepository;

  @Override
  public void run(String... args) {
    userRepository.save(new User(null, "antek", "antekpassword",
        "Antek", "Kowalski"));
  }
}

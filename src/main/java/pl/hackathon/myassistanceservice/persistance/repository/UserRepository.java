package pl.hackathon.myassistanceservice.persistance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.hackathon.myassistanceservice.persistance.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

}

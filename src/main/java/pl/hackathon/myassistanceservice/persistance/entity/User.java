package pl.hackathon.myassistanceservice.persistance.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private int points;

  @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<Assistance> created; //TODO RENAME THE FIELD

  @OneToMany(mappedBy = "assistant", fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<Assistance> assistances; //TODO RENAME THE FIELD
}

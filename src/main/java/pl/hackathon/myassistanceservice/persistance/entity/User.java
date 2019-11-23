package pl.hackathon.myassistanceservice.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;

  //TODO ADD RELATION TO 'AD' ENTITY
}

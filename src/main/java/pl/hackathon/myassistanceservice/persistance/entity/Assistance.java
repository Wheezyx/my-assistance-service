package pl.hackathon.myassistanceservice.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import pl.hackathon.myassistanceservice.persistance.enums.AssistanceStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Assistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private String creator; //TODO: connect with user, @OneToOne

    private String assistant; //TODO: connect with user, @OneToOne

    @Enumerated(EnumType.STRING)
    private AssistanceStatus assistanceStatus;

}

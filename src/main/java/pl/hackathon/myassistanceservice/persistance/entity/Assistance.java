package pl.hackathon.myassistanceservice.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import pl.hackathon.myassistanceservice.persistance.enums.AssistanceStatus;
import pl.hackathon.myassistanceservice.rest.dto.AssistanceDto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "creator")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "assistant")
    private User assistant;

    @Enumerated(EnumType.STRING)
    private AssistanceStatus assistanceStatus;

    private String disabilityType;

    private String helpType;

    public AssistanceDto toDto() {
        return new AssistanceDto()
                .setId(this.id)
                .setLatitude(this.latitude)
                .setLongitude(this.longitude)
                .setCreator(this.creator != null ? this.creator.getId() : null)
                .setCreatorName(this.creator != null ? this.creator.getUsername() : null)
                .setAssistant(this.assistant != null ? this.assistant.getId() : null)
                .setAssistantName(this.assistant != null ? this.assistant.getUsername() : null)
                .setAssistanceStatus(this.assistanceStatus)
                .setDisabilityType(this.disabilityType)
                .setHelpType(this.helpType);
    }
}

package pl.hackathon.myassistanceservice.rest.controller;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;
import pl.hackathon.myassistanceservice.rest.dto.AssistanceDto;
import pl.hackathon.myassistanceservice.service.AssistanceService;

@RestController
@RequestMapping("/assistance")
@AllArgsConstructor
public class AssistanceController {

  private final AssistanceService assistanceService;

  @GetMapping(value = "/range")
  public ResponseEntity getAssistances(@RequestParam double latitude,
      @RequestParam double longitude,
      @RequestParam(defaultValue = "10.0") double range) {
    Set<AssistanceDto> assistances = assistanceService
        .findAssistancesInRange(latitude, longitude, range);
    return ResponseEntity.ok(assistances);
  }

  @PostMapping("/user/{id}")
  public ResponseEntity<AssistanceDto> saveAssistance(@PathVariable("id") Long creatorId,
      @RequestBody Assistance assistanceToSave) {

    Assistance savedAssistance = assistanceService.saveAssistance(assistanceToSave, creatorId);

    return ResponseEntity.ok(savedAssistance.toDto());

  }

  @PostMapping("/{assistanceId}/user/{userId}/assign")
  public ResponseEntity<AssistanceDto> assignAssistance(
      @PathVariable("assistanceId") Long assistanceId, @PathVariable("userId") Long assistantId) {
    Assistance updatedAssistance = assistanceService
        .assignAssistance(assistanceId, assistantId);

    return ResponseEntity.ok(updatedAssistance.toDto());
  }

  @PutMapping("/{assistanceId}")
  public ResponseEntity<AssistanceDto> updateAssistance(@PathVariable("assistanceId") Long id,
      @RequestBody Assistance assistance) {
    //TODO CONSIDER REPLACE ENTITY WITH DTO
    Assistance updatedAssistance = assistanceService.updateAssistance(id, assistance);
    return ResponseEntity.ok(updatedAssistance.toDto());
  }

}

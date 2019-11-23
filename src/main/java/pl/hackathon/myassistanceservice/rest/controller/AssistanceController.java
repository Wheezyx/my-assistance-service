package pl.hackathon.myassistanceservice.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.hackathon.myassistanceservice.persistance.entity.Assistance;
import pl.hackathon.myassistanceservice.service.AssistanceService;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/assistance")
@AllArgsConstructor
public class AssistanceController {

    private final AssistanceService assistanceService;

    @GetMapping
    public ResponseEntity getAssistances(@RequestParam double latitude,
                                         @RequestParam double longitude,
                                         @RequestParam(defaultValue = "10.0") double range) {
        Set<Assistance> assistances = assistanceService.findAssistancesInRange(latitude, longitude, range);
        return ResponseEntity.ok(assistances);
    }
}

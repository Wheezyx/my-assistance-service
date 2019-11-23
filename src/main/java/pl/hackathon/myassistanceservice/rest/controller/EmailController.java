package pl.hackathon.myassistanceservice.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.hackathon.myassistanceservice.service.EmailService;

import java.util.Map;

@RestController
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/sendMail")
    public void recoverPassword(@RequestBody Map<String, String> data) {
        emailService.sendMail(data.get("email"),data.get("username"));
    }
}

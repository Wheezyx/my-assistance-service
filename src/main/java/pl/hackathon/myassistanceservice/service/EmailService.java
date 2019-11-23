package pl.hackathon.myassistanceservice.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendMail(SimpleMailMessage simpleMailMessage);
}

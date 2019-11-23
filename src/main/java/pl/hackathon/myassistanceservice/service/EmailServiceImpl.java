package pl.hackathon.myassistanceservice.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;

    @Override
    public void sendMail(SimpleMailMessage simpleMailMessage) {
        mailSender.send(simpleMailMessage);
    }
}

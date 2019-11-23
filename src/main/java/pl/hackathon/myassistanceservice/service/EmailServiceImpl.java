package pl.hackathon.myassistanceservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.hackathon.myassistanceservice.persistance.entity.User;
import pl.hackathon.myassistanceservice.persistance.repository.UserRepository;
import pl.hackathon.myassistanceservice.utils.MailMessageTemplateUtil;
import pl.hackathon.myassistanceservice.utils.MessageData;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;
    private UserRepository repository;
    @Value("${frontend.url}")
    private String baseUrl;

    public EmailServiceImpl(JavaMailSender mailSender, UserRepository repository) {
        this.mailSender = mailSender;
        this.repository = repository;
    }

    @Async
    @Override
    public void sendMail(String directEmail, String directUsername, String assistantUsername) {
        String helperPersonLink = createAssistancePersonLink(assistantUsername);
        MessageData messageData = new MessageData(directUsername, assistantUsername, helperPersonLink);
        String subject = MailMessageTemplateUtil.createMessageSubjectTemplate();
        String text = MailMessageTemplateUtil.createMessageContentTemplate(messageData);
        String from = MailMessageTemplateUtil.getServiceEmail();

        MimeMessage mimeMessage = processSendMailRequest(directEmail, from, subject, text);

        mailSender.send(mimeMessage);
    }

    private String createAssistancePersonLink(String assistanceUsername) {
        User assistant = repository.findByUsername(assistanceUsername).orElseThrow(() ->
                new RuntimeException("Creator not found"));
        return baseUrl + "/user/" + assistant.getUsername();
    }

    private MimeMessage processSendMailRequest(String to, String from, String subject, String text) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setReplyTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return mimeMessage;
    }

}

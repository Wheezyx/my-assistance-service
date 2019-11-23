package pl.hackathon.myassistanceservice.service;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.hackathon.myassistanceservice.utils.MailMessageTemplateUtil;
import pl.hackathon.myassistanceservice.utils.MessageData;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;

    @Async
    @Override
    public void sendMail(String directEmail, String directUsername,String helperUsername) {
        MessageData messageData = new MessageData(directUsername,helperUsername,"www.onet.pl");
        String subject = MailMessageTemplateUtil.createMessageSubjectTemplate();
        String text = MailMessageTemplateUtil.createMessageContentTemplate(messageData);
        String from = MailMessageTemplateUtil.getServiceEmail();

        MimeMessage mimeMessage = processSendMailRequest(directEmail, from, subject, text);

        mailSender.send(mimeMessage);
    }
    private MimeMessage processSendMailRequest(String to, String from, String subject, String text){
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

package pl.hackathon.myassistanceservice.service;

public interface EmailService {
    void sendMail(String directEmail, String directUsername, String assistantUsername);
}

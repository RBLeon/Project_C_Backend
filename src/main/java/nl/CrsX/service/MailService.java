package nl.CrsX.service;

public interface MailService{
    void sendMail(String to, String subject, String body);

    void sendPreConfiguredMail(String message);

    void sendSimpleMessage(String to, String subject, String body);
}
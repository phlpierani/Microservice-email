package com.ms.email.Service;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired // injeção de dependência
    EmailRepository emailRepository; // repositório de email

    @Autowired
    private JavaMailSender emailSender; // injeção de dependência do JavaMailSender

    public EmailModel sendEmail(EmailModel emailModel) {
        // lógica para enviar o email
        emailModel.setSendDateEmail(LocalDateTime.now()); // define a data de envio do email
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom()); // define o email de quem envia
            message.setTo(emailModel.getEmailTo()); // define o email de quem recebe
            message.setSubject(emailModel.getSubject()); // define o assunto do email
            message.setText(emailModel.getText()); // define o texto do email
            emailSender.send(message); // envia o email

            emailModel.setStatusEmail(StatusEmail.SENT); // define o status do email como enviado

        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR); // define o status do email como erro
        } finally {
            return emailRepository.save(emailModel); // salva o email no banco de dados
        }
    }
}

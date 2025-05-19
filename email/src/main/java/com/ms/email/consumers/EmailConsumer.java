package com.ms.email.consumers;

import com.ms.email.DTOs.EmailDTO;
import com.ms.email.Service.EmailService;
import com.ms.email.models.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    // Aqui você pode implementar a lógica para consumir mensagens da fila RabbitMQ
    // e processar os emails. Isso pode incluir a configuração de um listener

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}") // Nome da fila
    public void listen(@Payload EmailDTO emailDTO){ // recebe o payload da mensagem
        EmailModel emailModel = new EmailModel(); // cria um novo modelo de email
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel); // Chama o serviço de email para enviar o email
        System.out.println("Email status" + emailModel.getStatusEmail().toString());

    }
}

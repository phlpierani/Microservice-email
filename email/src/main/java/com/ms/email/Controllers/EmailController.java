package com.ms.email.Controllers;

import com.ms.email.DTOs.EmailDTO;
import com.ms.email.Service.EmailService;
import com.ms.email.models.EmailModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService; // injeção de dependência do serviço de email

    @PostMapping("/sending-email") // mapeia a requisição para o método
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel(); // cria um novo modelo de email
        BeanUtils.copyProperties(emailDTO, emailModel); // copia as propriedades do DTO para o model
        emailService.sendEmail(emailModel); // chama o serviço de email para enviar o email
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED); // retorna o email enviado
    }

}

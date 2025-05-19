package com.ms.email.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmailDTO {

    @NotBlank // valida se o campo não está vazio
    private String ownerRef; // referencia do dono do email

    @NotBlank
    @Email // valida se o campo é um email
    private String emailFrom; // email de quem envia

    @NotBlank
    @Email
    private String emailTo; // email de quem recebe

    @NotBlank
    private String subject; // assunto do email

    @Column(columnDefinition = "TEXT") // define o tipo da coluna como texto
    private String text;
}

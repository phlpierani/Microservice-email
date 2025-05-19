package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_EMAIL") // nome da tabela no banco de dados
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId; // id do email
    private String ownerRef; // referencia do dono do email
    private String emailFrom; // email de quem envia
    private String emailTo; // email de quem recebe
    private String subject; // assunto do email

    @Column(columnDefinition = "TEXT") // define o tipo da coluna como texto
    private String text; // texto do email
    private LocalDateTime sendDateEmail; // data de envio do email
    private StatusEmail statusEmail; // status do email

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

}

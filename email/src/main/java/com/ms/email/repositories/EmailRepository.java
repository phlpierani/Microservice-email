package com.ms.email.repositories;

import com.ms.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository  extends JpaRepository<EmailModel, UUID> {
    // JpaRepository já possui métodos prontos para manipulação de dados
    // como salvar, buscar, deletar, etc.
}

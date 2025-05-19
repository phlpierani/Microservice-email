# Microservice-email
Projeto de microserviço de envio de e-mails desenvolvido em Java, com arquitetura REST, integração com SMTP, tratamento de exceções e fila de mensagens. Permite envio assíncrono, alta escalabilidade e fácil integração com outros sistemas. Ideal para notificações automatizadas.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Mail
- Spring AMQP (RabbitMQ)
- Maven

## 🧱 Arquitetura

- API REST para recebimento dos pedidos de envio.
- RabbitMQ para fila de mensagens e comunicação assíncrona.
- SMTP como protocolo de envio de e-mails.
- Persistência dos envios com status.
- Separação em camadas (Controller, Service, DTO, Model, Repository).


## 📬 Funcionamento

1. A API recebe uma requisição com os dados do e-mail.
2. A mensagem é enviada para uma fila no RabbitMQ.
3. O consumidor escuta a fila e envia o e-mail via SMTP.
4. O envio é salvo no banco com status (ENVIADO ou ERRO).

POST /sending-email
Content-Type: application/json

{
  "ownerRef": "SistemaX",
  "emailFrom": "sistema@email.com",
  "emailTo": "usuario@email.com",
  "subject": "Confirmação de Cadastro",
  "text": "Seu cadastro foi realizado com sucesso!"
}

✅ Status do Projeto
✅ Funcional
🔄 Em constante melhoria
🚀 Pronto para integração com outros microsserviços

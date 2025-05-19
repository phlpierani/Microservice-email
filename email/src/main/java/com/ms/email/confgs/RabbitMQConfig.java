package com.ms.email.confgs;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

import java.util.Collection;
import java.util.Iterator;


@Configuration
public class RabbitMQConfig {
    // Configurações do RabbitMQ podem ser feitas aqui, como filas, exchanges, etc.
    @Value("${spring.rabbitmq.queue}") // Lê a propriedade do arquivo application.properties
    private String queue; // Nome da fila
     @Bean
     public Queue queue() { // Método que cria a fila
         return new Queue(queue, true); // Fila durável
     }

     @Bean
    Jackson2JsonMessageConverter messageConverter(){ // Método que converte mensagens
         return new Jackson2JsonMessageConverter(); // Converte mensagens para JSON
     }

}

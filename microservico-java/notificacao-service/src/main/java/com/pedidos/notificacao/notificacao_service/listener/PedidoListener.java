package com.pedidos.notificacao.notificacao_service.listener;


import com.pedidos.notificacao.notificacao_service.entity.Pedido;
import com.pedidos.notificacao.notificacao_service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);
    private final EmailService emailService;

    public PedidoListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido){

        logger.info("enviando pedido");

        // TESTE PARA CONCERTAR O LOOP INFINITO DE EXCEPTION
        if (pedido.getTotalPrice() > 3000){
            throw new RuntimeException("valor muito alto");
        }
        emailService.enviarEmail(pedido);
        logger.info("notificação gerada {}", pedido);
    }
}

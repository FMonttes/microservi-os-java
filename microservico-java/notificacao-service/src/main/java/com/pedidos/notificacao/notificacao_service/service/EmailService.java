package com.pedidos.notificacao.notificacao_service.service;

import com.pedidos.notificacao.notificacao_service.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmail(Pedido pedido){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("pedidos-api@localhost.com");
        simpleMailMessage.setTo(pedido.getEmailNotification());
        simpleMailMessage.setSubject("pedido de compra");
        simpleMailMessage.setText(this.gerarMensagem(pedido));
        javaMailSender.send(simpleMailMessage);
    }

    public  String gerarMensagem(Pedido pedido){
        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getClient();
        String valor = String.valueOf(pedido.getTotalPrice());
        String status = pedido.getStatus().name();
        return String.format("Olá %s seu pedido de nº %s,no valor de %s, foi realizado com sucesso.\nStatus %s",
                cliente, pedidoId, valor, status);
    }
}

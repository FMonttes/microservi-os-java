package com.pedidos.notificacao.notificacao_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.pedidos_api.entity.ItenPedido;
import com.microservices.pedidos_api.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private UUID id = UUID.randomUUID();
    private String client;
    private List<ItenPedido> itens = new ArrayList<>();
    private Double totalPrice;
    private String emailNotification;
    private Status status = Status.PROCESSING;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<ItenPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItenPedido> itens) {
        this.itens = itens;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(String emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(client, pedido.client);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(client);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", itens=" + itens +
                ", totalPrice=" + totalPrice +
                ", emailNotification='" + emailNotification + '\'' +
                ", status=" + status +
                ", dateTime=" + dateTime +
                '}';
    }
}

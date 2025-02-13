package com.pedidos.processador.repository;

import com.pedidos.processador.entity.ItenPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItenPedido, UUID> {
}

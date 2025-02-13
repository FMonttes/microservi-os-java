package com.pedidos.processador.service;

import com.pedidos.processador.entity.ItenPedido;
import com.pedidos.processador.entity.Pedido;
import com.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }

//    public void save(Pedido pedido){
//
//        produtoService.save(pedido.getItens());
//        List<ItenPedido> itenPedido = itemPedidoService.save(pedido.getItens());
//        pedidoRepository.save(pedido);
//        itemPedidoService.updatedItenPedido(itenPedido, pedido);
//        logger.info("pedido salvo: {}", pedido.toString());
//    }

    public void save(Pedido pedido){
        produtoService.save(pedido.getItens());
        List<ItenPedido> itenPedidos = itemPedidoService.save(pedido.getItens());
        pedidoRepository.save(pedido);
        itemPedidoService.updateItenPeidido(itenPedidos, pedido);
    }
}

package com.pedidos.processador.service;

import com.pedidos.processador.entity.ItenPedido;
import com.pedidos.processador.entity.Pedido;
import com.pedidos.processador.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemRepository itemRepository;

    public ItemPedidoService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItenPedido> save(List<ItenPedido> itens) {
        return itemRepository.saveAll(itens);
    }

    public void save(ItenPedido itenPedido){
        itemRepository.save(itenPedido);
    }
    public void updateItenPeidido(List<ItenPedido> itenPedidos, Pedido pedido) {
        itenPedidos.forEach(item -> {
            item.setPedido(pedido);
            this.save(item);
        });
    }

//    public List<ItenPedido> save(List<ItenPedido> itens) {
//        return itemRepository.saveAll(itens);
//    }
//
//    public void save(ItenPedido itenPedido){
//        itemRepository.save(itenPedido);
//    }
//    public void updatedItenPedido(List<ItenPedido> itenPedido, Pedido pedido) {
//        itenPedido.forEach(item-> {
//            item.setPedido(pedido);
//            this.save(item);
//        });
//    }
}

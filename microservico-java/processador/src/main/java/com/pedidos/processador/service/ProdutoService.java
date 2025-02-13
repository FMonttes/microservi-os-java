package com.pedidos.processador.service;

import com.pedidos.processador.entity.ItenPedido;
import com.pedidos.processador.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void save(List<ItenPedido> itens) {
        itens.forEach(item -> produtoRepository.save(item.getProduct()));
    }
    }

//    public void save(List<ItenPedido> itens) {
//        itens.forEach(item
//                -> produtoRepository.save(item.getProduct()));
//    }
//}


package com.usabana.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usabana.pedido.model.Pedido;
import com.usabana.pedido.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido obtener(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }
}

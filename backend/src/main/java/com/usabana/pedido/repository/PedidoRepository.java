
package com.usabana.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usabana.pedido.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

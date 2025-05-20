package com.labo2.pasteleria.laboratorio2.Repositories;

import com.labo2.pasteleria.laboratorio2.Entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    // Buscar factura por ID de pedido (asumiendo que Pedido tiene ID tipo Long)
    Optional<Factura> findByPedido_PedidoId(Long pedidoId);

    // Buscar todas las facturas por método de pago
    // (por ejemplo: "Tarjeta", "Efectivo", etc.)
    java.util.List<Factura> findByMetodoPago(String metodoPago);
}

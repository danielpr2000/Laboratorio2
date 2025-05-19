package com.labo2.pasteleria.laboratorio2.Repositories;

import com.labo2.pasteleria.laboratorio2.Entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

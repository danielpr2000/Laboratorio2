package com.labo2.pasteleria.laboratorio2.Repositories;

import com.labo2.pasteleria.laboratorio2.Entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Buscar pedidos por nombre del cliente
    List<Pedido> findByNombreContainingIgnoreCase(String nombre);

    // Buscar pedidos por fecha de registro exacta
    List<Pedido> findByFechaRegistro(LocalDate fecha);

    // Buscar pedidos por email (si es único o clave)
    List<Pedido> findByEmail(String email);
}

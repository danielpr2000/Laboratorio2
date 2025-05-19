package com.labo2.pasteleria.laboratorio2.Repositories;

import com.labo2.pasteleria.laboratorio2.Entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}

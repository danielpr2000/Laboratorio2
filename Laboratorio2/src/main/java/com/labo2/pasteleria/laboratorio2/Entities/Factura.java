package com.labo2.pasteleria.laboratorio2.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facturaId;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(nullable = false)
    private String metodoPago;

    @Column(nullable = false, precision = 10, scale = 2)
    private float impuesto;

    @Column(nullable = false, precision = 10, scale = 2)
    private float total;

    private LocalDate fechaPago;

    @PrePersist
    protected void onCreate() {
        this.fechaPago = LocalDate.now();
    }
}

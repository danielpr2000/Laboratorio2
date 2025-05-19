package com.labo2.pasteleria.laboratorio2.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String email;

    private String telefono;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDate.now();
    }

}

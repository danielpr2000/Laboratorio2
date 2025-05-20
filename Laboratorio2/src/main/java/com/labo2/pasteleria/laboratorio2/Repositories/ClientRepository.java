package com.labo2.pasteleria.laboratorio2.Repositories;

import com.labo2.pasteleria.laboratorio2.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Buscar por nombre
    List<Client> findByNombreContainingIgnoreCase(String nombre);

    // Buscar por email (como es único, se usa Optional)
    Optional<Client> findByEmail(String email);

    // Buscar por apellido exacto
    List<Client> findByApellido(String apellido);
}

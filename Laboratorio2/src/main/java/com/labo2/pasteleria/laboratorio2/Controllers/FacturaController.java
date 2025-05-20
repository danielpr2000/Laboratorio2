package com.labo2.pasteleria.laboratorio2.Controllers;

import com.labo2.pasteleria.laboratorio2.Entities.Factura;
import com.labo2.pasteleria.laboratorio2.Repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaRepository.save(factura);
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la factura con el ID: " + id));
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        Factura existingFactura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la factura con el ID: " + id));

        existingFactura.setMetodoPago(factura.getMetodoPago());
        existingFactura.setImpuesto(factura.getImpuesto());
        existingFactura.setTotal(factura.getTotal());
        existingFactura.setFechaPago(factura.getFechaPago());

        return facturaRepository.save(existingFactura);
    }

    @DeleteMapping("/{id}")
    public String deleteFactura(@PathVariable Long id) {
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la factura con el ID: " + id));
        facturaRepository.deleteById(id);
        return "La factura con ID " + id + " fue eliminada correctamente";
    }
}

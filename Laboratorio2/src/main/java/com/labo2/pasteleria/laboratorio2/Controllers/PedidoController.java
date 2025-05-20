package com.labo2.pasteleria.laboratorio2.Controllers;

import com.labo2.pasteleria.laboratorio2.Entities.Pedido;
import com.labo2.pasteleria.laboratorio2.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el pedido con el ID: " + id));
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido existingPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el pedido con el ID: " + id));

        existingPedido.setNombre(pedido.getNombre());
        existingPedido.setApellido(pedido.getApellido());
        existingPedido.setEmail(pedido.getEmail());
        existingPedido.setTelefono(pedido.getTelefono());
        existingPedido.setDireccion(pedido.getDireccion());

        return pedidoRepository.save(existingPedido);
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el pedido con el ID: " + id));
        pedidoRepository.deleteById(id);
        return "El pedido con ID " + id + " fue eliminado correctamente";
    }
}

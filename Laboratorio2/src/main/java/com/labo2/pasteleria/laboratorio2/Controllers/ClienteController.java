package com.labo2.pasteleria.laboratorio2.Controllers;

import com.labo2.pasteleria.laboratorio2.Entities.Client;
import com.labo2.pasteleria.laboratorio2.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientRepository clientRepository;

     @GetMapping
    public List<Client> getAllClients(){
        return clientRepository.findAll();
     }
     @PostMapping
    public Client createClient(@RequestBody Client client){
         return clientRepository.save(client);
     }

     @GetMapping("/{id}")
     public Client getProductById(@PathVariable Long id){
         return clientRepository.findById(id)
                 .orElseThrow(()-> new RuntimeException("No se encontro el producto con el Id" + id));
     }

     @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        Client cliente =  clientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID:" + id));

        cliente.setNombre(client.getNombre());
        cliente.setApellido(client.getApellido());

        return clientRepository.save(cliente);
     }

     @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) {
         Client cliente = clientRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID:" + id));
         return "El producto con Id" + id +" fue eliminado correctamente";
     }

}

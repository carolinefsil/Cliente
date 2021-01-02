package com.example.demo.controller;


import com.example.demo.Cliente;
import com.example.demo.services.ClienteServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")  //endpoint que será utilizado para realizar requisições
public class ClienteResource {

    @Autowired(required=true)
    private ClienteServiceAPI service;

    @GetMapping("/{id}")
    @ResponseBody
    HttpEntity<Object> get(@PathVariable(name = "id") Long id) {

        Cliente cliente = service.get(id);
        return ResponseEntity.ok(cliente);
    }


    @GetMapping
    @ResponseBody HttpEntity<Object> findAll() {

        List<Cliente> Cliente = service.findAll();

        if(Cliente.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(Cliente);
    }


    @PostMapping
    @ResponseBody HttpEntity<Object> create(@RequestBody Cliente cliente){

        cliente = service.create(cliente);
        return ResponseEntity.ok(cliente);
    }


    @PutMapping("/{id}")
    @ResponseBody  HttpEntity<Object> update(@PathVariable(name = "id") Long id,
                                             @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        service.update(cliente);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    @ResponseBody  HttpEntity<Object> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}


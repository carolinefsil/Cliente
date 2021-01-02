package com.example.demo.services;

import com.example.demo.Cliente;
import com.example.demo.ClienteRepository;
import com.example.demo.exceptions.ClienteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService implements ClienteServiceAPI{

    @Autowired(required=true)
    private ClienteRepository repositoryJPA;

    @Transactional(readOnly = true)
    public Cliente get(Long id){

        try {
            Cliente cliente = repositoryJPA.findById(id).get();
            return cliente;
        } catch (Exception ex) {
            throw new ClienteNotFoundException(String.format("Cliente não encontrado: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Cliente create(Cliente cliente) {

        return repositoryJPA.save(cliente);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Cliente cliente) {
        repositoryJPA.save(cliente);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }
}
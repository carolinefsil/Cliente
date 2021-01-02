package com.example.demo.services;

import com.example.demo.Cliente;

import java.util.List;

public interface ClienteServiceAPI {

    public Cliente get(Long id);

    public List<Cliente> findAll();

    public Cliente create(Cliente cliente);

    public void update(Cliente cliente);

    public void remove(Long id);
}

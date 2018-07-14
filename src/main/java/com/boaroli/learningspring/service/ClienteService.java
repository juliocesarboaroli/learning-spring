package com.boaroli.learningspring.service;

import com.boaroli.learningspring.model.Cliente;
import com.boaroli.learningspring.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente find(Long id) {
        return repository.findById(id).get();
    }

    public Cliente findByDocumento(String documento) {
        return repository.findByDocumento(documento);
    }

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}

package com.boaroli.learningspring.resource;

import com.boaroli.learningspring.model.Cliente;
import com.boaroli.learningspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("clientes")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @GetMapping("documento")
    public Cliente findByDocumento(@RequestParam("documento") String documento) {
        return service.findByDocumento(documento);
    }

    @GetMapping("{id}")
    public Cliente find(@PathVariable("id") Long id) {
        return service.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return service.insert(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        if (!id.equals(cliente.getId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.update(cliente));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id) {
        service.remove(id);
    }
}

package com.boaroli.learningspring.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
@SequenceGenerator(name = "seq_clientes", allocationSize = 1)
public class Cliente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clientes")
    private Long id;

    @NotNull(message = "{Cliente.nome.NotNull}")
    @Size(min = 5, max = 80, message = "{Cliente.nome.Size}")
    private String nome;

    @NotNull
    @Size(min = 11, max = 18)
    private String documento;

    @Size(min = 4, max = 100)
    private String email;

    @Size(min = 8, max = 20)
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

package com.exemplo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    @Size(min = 2, max = 120, message = "nome deve ter entre 2 e 120 caracteres")
    @Column(nullable = false, length = 120)
    private String nome;

    @NotBlank(message = "email é obrigatório")
    @Email(message = "email deve ser válido")
    @Size(max = 254, message = "email deve ter até 254 caracteres")
    @Column(nullable = false, unique = true, length = 254)
    private String email;

    @Size(max = 30, message = "telefone deve ter até 30 caracteres")
    @Column(length = 30)
    private String telefone;

    @Column(nullable = false, updatable = false)
    private Instant criadoEm;

    @Column(nullable = false)
    private Instant atualizadoEm;

    protected Cliente() { }

    @JsonCreator
    public Cliente(@JsonProperty("nome") String nome,
                   @JsonProperty("email") String email,
                   @JsonProperty("telefone") String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @PrePersist
    void aoCriar() {
        Instant agora = Instant.now();
        criadoEm = agora;
        atualizadoEm = agora;
    }

    @PreUpdate
    void aoAtualizar() {
        atualizadoEm = Instant.now();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public Instant getCriadoEm() { return criadoEm; }
    public Instant getAtualizadoEm() { return atualizadoEm; }

    public void atualizar(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}

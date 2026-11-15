package com.exemplo.api.service;

import com.exemplo.api.model.Cliente;
import com.exemplo.api.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public long contar() {
        return repository.count();
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe um nome para a busca.");
        }
        return repository.findByNomeContainingIgnoreCase(nome.trim());
    }

    @Transactional
    public Cliente criar(Cliente entrada) {
        normalizar(entrada);
        if (repository.existsByEmailIgnoreCase(entrada.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um cliente com este email.");
        }
        return repository.save(entrada);
    }

    @Transactional
    public Cliente atualizar(Long id, Cliente entrada) {
        Cliente atual = buscarPorId(id);
        normalizar(entrada);
        if (repository.existsByEmailIgnoreCaseAndIdNot(entrada.getEmail(), id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um cliente com este email.");
        }
        atual.atualizar(entrada.getNome(), entrada.getEmail(), entrada.getTelefone());
        return repository.save(atual);
    }

    @Transactional
    public void excluir(Long id) {
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
    }

    private void normalizar(Cliente cliente) {
        cliente.atualizar(cliente.getNome().trim(), cliente.getEmail().trim().toLowerCase(),
                cliente.getTelefone() == null || cliente.getTelefone().isBlank() ? null : cliente.getTelefone().trim());
    }
}

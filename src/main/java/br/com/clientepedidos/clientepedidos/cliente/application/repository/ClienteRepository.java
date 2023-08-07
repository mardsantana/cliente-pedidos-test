package br.com.clientepedidos.clientepedidos.cliente.application.repository;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Cliente buscarClientePorEmail(String email);
    void deleteCliente(Cliente cliente);
    List<Cliente> listaClientePorEmail();
}

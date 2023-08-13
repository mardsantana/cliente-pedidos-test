package br.com.clientepedidos.clientepedidos.cliente.repository;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Cliente buscaClientePorNome(String nome);
    void deleteCliente(Cliente cliente);
    List<Cliente> buscaClientesGerais();
}

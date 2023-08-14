package br.com.clientepedidos.clientepedidos.cliente.repository;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Cliente buscaClientePorID(UUID idCliente);
    void deleteCliente(Cliente cliente);
    List<Cliente> buscaClientesGerais();
}

package br.com.clientepedidos.clientepedidos.cliente.application.repository;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
//    Cliente buscaClienteAtravesNome(String nomeCompleto);

}

package br.com.clientepedidos.clientepedidos.cliente.service;


import br.com.clientepedidos.clientepedidos.cliente.api.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);
    ClienteDetalhadoResponse buscaClientePorID(UUID idCliente);
    void deleteClientePorID(UUID idCliente);
    List<ClienteListResponse> buscaClientesGerais();
    void alteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
}

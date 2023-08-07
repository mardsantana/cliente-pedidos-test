package br.com.clientepedidos.clientepedidos.cliente.application.service;


import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteList;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteResponse;

import javax.validation.Valid;
import java.util.List;

public interface ClienteService {
    ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);
    void alteraCliente(String email, ClienteAlteracaoRequest clienteAlteracaoRequest);
    void deleteClientePorEmail(String email);
    List<ClienteList> clientePorEmail(String email);
    List<ClienteList> todosOsClientes();
}

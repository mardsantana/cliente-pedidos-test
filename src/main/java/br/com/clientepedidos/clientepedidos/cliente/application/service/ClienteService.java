package br.com.clientepedidos.clientepedidos.cliente.application.service;


import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse criaUsuario(ClienteRequest clienteRequest);
//    void patchCliente(String nomeCompleto, ClienteAlteracaoRequest clientealteracaoRequest);
}

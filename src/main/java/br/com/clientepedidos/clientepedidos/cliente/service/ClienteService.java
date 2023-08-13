package br.com.clientepedidos.clientepedidos.cliente.service;


import br.com.clientepedidos.clientepedidos.cliente.api.*;

import javax.validation.Valid;
import java.util.List;

public interface ClienteService {
    ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);
    ClienteDetalhadoResponse buscaClientePorNome(String nome);
    void deleteClientePorNome(String nome);
    List<ClienteListResponse> buscaClientesGerais();
    void alteraCliente(String nome, ClienteAlteracaoRequest clienteAlteracaoRequest);
}

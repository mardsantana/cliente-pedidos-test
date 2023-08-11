package br.com.clientepedidos.clientepedidos.cliente.application.service;


import br.com.clientepedidos.clientepedidos.cliente.application.api.*;
import br.com.clientepedidos.clientepedidos.cliente.application.repository.ClienteRepository;
import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - criaCliente");
        Cliente cliente = clienteRepository.save(new Cliente(clienteRequest));
        log.info("[finish] ClienteApplicationService - criaCliente");
        return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
    }
    @Override
    public ClienteDetalhadoResponse buscaClientePorNome(String nome) {
        log.info("[start] ClienteApplicationService - buscaClientePorNome");
        Cliente cliente = clienteRepository.buscaClientePorNome(nome);
        log.info("[finish] ClienteApplicationService - buscaClientePorNome");
        return new ClienteDetalhadoResponse(cliente);
    }
    @Override
    public void deleteClientePorNome(String nome) {
        log.info("[start] ClienteApplicationService - deleteClientePorNome");
        Cliente cliente = clienteRepository.buscaClientePorNome(nome);
        clienteRepository.deleteCliente(cliente);
        log.info("[finish] ClienteApplicationService - deleteClientePorNome");
    }
    @Override
    public List<ClienteListResponse> buscaClientesGerais() {
        log.info("[start] ClienteApplicationService - buscaClientesGerais");
        List<Cliente> clientes = clienteRepository.buscaClientesGerais();
        log.info("[start] ClienteApplicationService - buscaClientesGerais");
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public void alteraCliente(String nome, ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[start] ClienteApplicationService - alteraCliente");
        Cliente cliente = clienteRepository.buscaClientePorNome(nome);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.save(cliente);
        log.info("[finish] ClienteApplicationService - alteraCliente");
    }
}

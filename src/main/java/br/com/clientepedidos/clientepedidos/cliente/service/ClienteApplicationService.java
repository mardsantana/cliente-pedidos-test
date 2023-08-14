package br.com.clientepedidos.clientepedidos.cliente.service;


import br.com.clientepedidos.clientepedidos.cliente.api.*;
import br.com.clientepedidos.clientepedidos.cliente.repository.ClienteRepository;
import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public ClienteDetalhadoResponse buscaClientePorID(UUID idCliente) {
        log.info("[start] ClienteApplicationService - buscaClientePorNome");
        Cliente cliente = clienteRepository.buscaClientePorID(idCliente);
        log.info("[finish] ClienteApplicationService - buscaClientePorNome");
        return new ClienteDetalhadoResponse(cliente);
    }
    @Override
    public void deleteClientePorID(UUID idCliente) {
        log.info("[start] ClienteApplicationService - deleteClientePorNome");
        Cliente cliente = clienteRepository.buscaClientePorID(idCliente);
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
    public void alteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[start] ClienteApplicationService - alteraCliente");
        Cliente cliente = clienteRepository.buscaClientePorID(idCliente);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.save(cliente);
        log.info("[finish] ClienteApplicationService - alteraCliente");
    }
}

package br.com.clientepedidos.clientepedidos.cliente.application.infra;


import br.com.clientepedidos.clientepedidos.cliente.application.repository.ClienteRepository;
import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente save(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - save");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finish] ClienteInfraRepository - save");
        return cliente;
    }
    @Override
    public Cliente buscarClientePorEmail(String email) {
        log.info("[start] ClienteInfraRepository - buscarClientePorEmail");
        Cliente cliente = (Cliente) clienteSpringDataJPARepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        log.info("[finish] ClienteInfraRepository - buscarClientePorEmail");
        return cliente;
    }
    @Override
    public void deleteCliente(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - deletaCliente");
        clienteSpringDataJPARepository.delete(cliente);
        log.info("[finish] ClienteInfraRepository - deletaCliente");
    }

    @Override
    public List<Cliente> listaClientePorEmail() {
        log.info("[start] ClienteInfraRepository - buscarPorEmail");
        List<Cliente> clientesGerais = clienteSpringDataJPARepository.findAll();
        log.info("[finish] ClienteInfraRepository - buscarPorEmail");
        return clientesGerais;

    }
    // Parte do PedidosApplicationService
//    @Override
//    public Cliente buscaPorEmail(String email) {
//        log.info("[start] ClienteInfraRepository - buscaPorEmail");
//        Cliente cliente = (Cliente) clienteSpringDataJPARepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("Pedido do Cliente não encontrado!"));
//        log.info("[finish] ClienteInfraRepository - buscaPorEmail");
//        return cliente;
//    }
}

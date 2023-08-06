package br.com.clientepedidos.clientepedidos.cliente.application.infra;


import br.com.clientepedidos.clientepedidos.cliente.application.repository.ClienteRepository;
import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente save(Cliente cliente) {
        log.info("[start] FormularioInfraRepository - save");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finish] FormularioInfraRepository - save");
        return cliente;
    }
    @Override
    public Cliente buscaPorNome(String nome) {
        log.info("[start] ClienteInfraRepository - buscaPorNome");
        Cliente cliente = (Cliente) clienteSpringDataJPARepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        log.info("[finish] ClienteInfraRepository - buscaPorNome");
        return cliente;
    }
}

package br.com.clientepedidos.clientepedidos.cliente.infra;


import br.com.clientepedidos.clientepedidos.cliente.repository.ClienteRepository;
import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import br.com.clientepedidos.clientepedidos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
        try {
            clienteSpringDataJPARepository.save(cliente);
        } catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
        }
        log.info("[finish] ClienteInfraRepository - save");
        return cliente;
    }
    @Override
    public Cliente buscaClientePorNome(String nome) {
        log.info("[start] ClienteInfraRepository - buscaClientePorNome");
        Cliente cliente = clienteSpringDataJPARepository.findByNome(nome)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não Encontrado!!!"));
        log.info("[finish] ClienteInfraRepository - buscaClientePorNome");
        return cliente;
    }
    @Override
    public void deleteCliente(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - deleteCliente");
        clienteSpringDataJPARepository.delete(cliente);
        log.info("[finish] ClienteInfraRepository - deleteCliente");
    }
    @Override
    public List<Cliente> buscaClientesGerais() {
        log.info("[start] ClienteInfraRepository - buscaClientesGerais");
        List<Cliente> clientesGerais = clienteSpringDataJPARepository.findAll();
        log.info("[finish] ClienteInfraRepository - buscaClientesGerais");
        return clientesGerais;
    }
}


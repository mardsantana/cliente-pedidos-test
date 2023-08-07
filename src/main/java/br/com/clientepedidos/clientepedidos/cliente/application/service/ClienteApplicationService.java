package br.com.clientepedidos.clientepedidos.cliente.application.service;


import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteList;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteResponse;
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
        log.info("[start] ClienteApplicationService - criaUsuario");
        Cliente cliente1 = new Cliente(clienteRequest);
        log.info("cliente1 = {}", cliente1);
        Cliente cliente = clienteRepository.save(cliente1);
        log.info("clienteFinal = {}", cliente);
        log.info("[finish] ClienteApplicationService - criaUsuario");
        return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
    }

//    log.info("[start] GerenciadorApplicationService - criaCadastro");
//    Gerenciador gerenciador1 = new Gerenciador(gerenciadorRequest);
//    log.info("gerenciador1 = {}", gerenciador1);
//    Gerenciador gerenciador = gerenciadorRepository.save(gerenciador1);
//    log.info("gerenciadorFinal = {}", gerenciador);
//    log.info("[finish] GerenciadorApplicationService - criaCadastro");
//    return GerenciadorResponse.builder().idAnimal(gerenciador.getIdAnimal()).build();










    @Override
    public void alteraCliente(String email, ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[start] ClienteApplicationService - alteraCliente");
        Cliente cliente = clienteRepository.buscarClientePorEmail(email);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.save(cliente);
        log.info("[finish] ClienteApplicationService - alteraCliente");
    }
    @Override
    public void deleteClientePorEmail(String email) {
        log.info("[start] UsuarioApplicationService - deleteClientePorEmail");
        Cliente cliente = clienteRepository.buscarClientePorEmail(email);
        clienteRepository.deleteCliente(cliente);
        log.info("[finish] UsuarioApplicationService - deleteClientePorEmail");
    }

    @Override
    public List<ClienteList> listaClientePorEmail() {
        log.info("[start] UsuarioApplicationService - buscaPorEmail");
        List<Cliente> cliente = clienteRepository.listaClientePorEmail();
        log.info("[finish] UsuarioApplicationService - buscaPorEmail");
        return ClienteList.converte(cliente);
    }

//    @Override
//    public ClienteRequest buscaPorEmail(String email) {
//        log.info("[start] UsuarioApplicationService - buscaPorEmail");
//        Cliente cliente = clienteRepository.buscaPorEmail(email);
//        log.info("[finish] UsuarioApplicationService - buscaPorEmail");
//        return new ClienteRequest(cliente);
//    }
}

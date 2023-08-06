package br.com.clientepedidos.clientepedidos.cliente.application.service;


import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteResponse;
import br.com.clientepedidos.clientepedidos.cliente.application.repository.ClienteRepository;
import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService{

    private final ClienteRepository clienteRepository;
//    private final ClienteAlteracaoRequest clienteAlteracaoRequest;

    @Override
    public ClienteResponse criaUsuario(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - criaUsuario");
        Cliente cliente = clienteRepository.save(new Cliente(clienteRequest));
        log.info("[finish] ClienteApplicationService - criaUsuario");
        return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
    }

//    @Override
//    public void patchCliente(String nomeCompleto, ClienteAlteracaoRequest clientealteracaoRequest) {
//        log.info("[start] ClienteApplicationService - patchCliente");
//        Cliente cliente = clienteRepository.buscaClienteAtravesNome(nomeCompleto);
//        cliente.altera(clienteAlteracaoRequest);
//        clienteRepository.save(cliente);
//        log.info("[finish] ClienteApplicationService - patchCliente");
//    }
}

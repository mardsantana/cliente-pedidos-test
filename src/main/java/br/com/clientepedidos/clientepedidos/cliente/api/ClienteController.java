package br.com.clientepedidos.clientepedidos.cliente.api;

import br.com.clientepedidos.clientepedidos.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        log.info("[start] ClienteController - postCliente");
        ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
        log.info("[finish] ClienteController - postCliente");
        return clienteCriado;
    }
    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteDetalhadoResponse buscaPorID(@PathVariable UUID idCliente){
        log.info("[start] ClienteController - buscaPorID");
        log.info("[idCliente] {}", idCliente);
        ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClientePorID(idCliente);
        log.info("[finish] ClienteController - buscaPorID");
        return clienteDetalhado;
    }
    @DeleteMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePorID(@PathVariable UUID idCliente){
        log.info("[start] ClienteController - deletePorNome");
        log.info("[idCliente] {}", idCliente);
        clienteService.deleteClientePorID(idCliente);
        log.info("[finish] ClienteController - deletePorNome");
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> buscaClientesGerais(){
        log.info("[start] ClienteController - buscaClientesGerais");
        List<ClienteListResponse> clientes = clienteService.buscaClientesGerais();
        log.info("[finish] ClienteController - buscaClientesGerais");
        return clientes;
    }
    @PatchMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchCliente(@PathVariable UUID idCliente,
                      @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[start] ClienteController - patchCliente");
        log.info("[idCliente]{}", idCliente);
        clienteService.alteraCliente(idCliente, clienteAlteracaoRequest);
        log.info("[finish] ClienteController - patchCliente");
    }
}

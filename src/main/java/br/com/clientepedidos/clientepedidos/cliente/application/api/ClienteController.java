package br.com.clientepedidos.clientepedidos.cliente.application.api;

import br.com.clientepedidos.clientepedidos.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping(value = "/{nome}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteDetalhadoResponse buscaPorNome(@PathVariable String nome){
        log.info("[start] ClienteController - buscaPorNome");
        log.info("[nome] {}", nome);
        ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClientePorNome(nome);
        log.info("[finish] ClienteController - buscaPorNome");
        return clienteDetalhado;
    }
    @DeleteMapping(value = "/{nome}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePorNome(@PathVariable String nome){
        log.info("[start] ClienteController - deletePorNome");
        log.info("[nome] {}", nome);
        clienteService.deleteClientePorNome(nome);
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
    @PatchMapping(value = "/{nome}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchCliente(@PathVariable String nome,
                      @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest){
        log.info("[start] ClienteController - patchCliente");
        log.info("[nome]{}", nome);
        clienteService.alteraCliente(nome, clienteAlteracaoRequest);
        log.info("[finish] ClienteController - patchCliente");
    }
}

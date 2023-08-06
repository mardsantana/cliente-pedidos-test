package br.com.clientepedidos.clientepedidos.cliente.application.api;

import br.com.clientepedidos.clientepedidos.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        ClienteResponse clienteCriado = clienteService.criaUsuario(clienteRequest);
        log.info("[finish] ClienteController - postCliente");
        return clienteCriado;
    }
    @PatchMapping(value = "/{nome}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraCliente(@PathVariable String nome, @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest){
        log.info("[start] ClienteController - alteraCliente");
        log.info("[nome]{}", nome);
        clienteService.alteraCliente(nome, clienteAlteracaoRequest);
        log.info("[finish] ClienteController - alteraCliente");
    }
}

//    Permitir o cadastro, alteração, deleção e consulta de clientes.

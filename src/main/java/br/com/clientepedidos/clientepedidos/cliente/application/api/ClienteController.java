package br.com.clientepedidos.clientepedidos.cliente.application.api;

import br.com.clientepedidos.clientepedidos.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        ClienteResponse clienteCriado = clienteService.criaUsuario(clienteRequest);
        log.info("[finish] ClienteController - postCliente");
        return clienteCriado;
    }

//    @PatchMapping(value = "/{nome}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public void patchCliente(@PathVariable String nomeCompleto, @Valid @RequestBody ClienteAlteracaoRequest clientealteracaoRequest){
//        log.info("[start] ClienteController - patchCliente");
//        log.info("[nomeCompleto] {}", nomeCompleto);
//        clienteService.patchCliente(nomeCompleto, clientealteracaoRequest);
//        log.info("[finish] ClienteController - patchCliente");
//    }

}

//    Permitir o cadastro, alteração, deleção e consulta de clientes.

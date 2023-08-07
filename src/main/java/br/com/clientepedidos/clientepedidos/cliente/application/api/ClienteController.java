package br.com.clientepedidos.clientepedidos.cliente.application.api;

import br.com.clientepedidos.clientepedidos.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
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
    @PatchMapping(value = "/{email}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraCliente(@PathVariable String email, @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest){
        log.info("[start] ClienteController - alteraCliente");
        log.info("[email]{}", email);
        clienteService.alteraCliente(email, clienteAlteracaoRequest);
        log.info("[finish] ClienteController - alteraCliente");
    }
    @DeleteMapping(value = "/{email}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteClientePorEmail(@PathVariable String email) {
        log.info("[start] ClienteController - deleteClientePorEmail");
        log.info("[email]{}", email);
        clienteService.deleteClientePorEmail(email);
        log.info("[finish] ClienteController - deleteClientePorEmail");
    }
    @GetMapping(value = "/{email}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteList> listaClientePorEmail(){
        log.info("[start] ClienteController - listaCliente");
        List<ClienteList> cliente = clienteService.listaClientePorEmail();
        log.info("[finish] ClienteController - listaCliente");
        return cliente;
    }
}
//    Permitir o cadastro, alteração, deleção e consulta de clientes.

package br.com.clientepedidos.clientepedidos.entregas.api;

import br.com.clientepedidos.clientepedidos.entregas.service.EntregasService;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente/entregas")
@Log4j2
@RequiredArgsConstructor
public class EntregasController {

    private final EntregasService entregasService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EntregasResponse postEntregas(@Valid @RequestBody EntregasRequest entregasRequest) {
        log.info("[start] EntregasController - postEntregas");
        EntregasResponse entregasCriado = entregasService.criaEntregas(entregasRequest);
        log.info("[finish] EntregasController - postEntregas");
        return entregasCriado;
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EntregasListResponse> buscaEntregasGerais(){
        log.info("[start] EntregasController - buscaEntregasGerais");
        List<EntregasListResponse> entregasGerais = entregasService.buscaEntregasGerais();
        log.info("[finish] EntregasController - buscaEntregasGerais");
        return entregasGerais;
    }
    @GetMapping(value = "/{idEntregas}")
    @ResponseStatus(code = HttpStatus.OK)
    EntregasListResponse buscaEntregaPorID(@PathVariable UUID idEntregas){
        log.info("[start] EntregasController - buscaEntregaPorID");
        EntregasListResponse buscaEntrega = entregasService.buscaEntregaPorID(idEntregas);
        log.info("finish] EntregasController - buscaEntregaPorID");
        return buscaEntrega;
    }
    @PatchMapping(value = "/{idEntregas}")
    @ResponseStatus(code = HttpStatus.OK)
    void alteraEntrega(@PathVariable UUID idEntregas, @Valid @RequestBody EntregasAlteracaoRequest entregasAlteracaoRequest){
        log.info("[start] EntregasController - alteraEntrega");
        log.info("[idEntregas] {}", idEntregas);
        entregasService.alteraEntrega(idEntregas, entregasAlteracaoRequest);
        log.info("[finish] EntregasController - alteraEntrega");
    }
    @DeleteMapping(value = "/{idEntregas}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteEntregasID(@PathVariable UUID idEntregas){
        log.info("[start] EntregasController - deleteEntregasID");
        log.info("[idEntregas] {}", idEntregas);
        entregasService.deleteEntregasID(idEntregas);
        log.info("[start] EntregasController - deleteEntregasID");
    }
}
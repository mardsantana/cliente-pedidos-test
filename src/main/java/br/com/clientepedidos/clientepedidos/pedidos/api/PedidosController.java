package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.service.PedidosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequestMapping("/cliente/{idClientePedidos}/pedidos")
@RequiredArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidosResponse postPedidos(@PathVariable UUID idClientePedidos, @Valid @RequestBody PedidosRequest pedidosRequest) {
        log.info("[start] PedidosController -  postPedidos");
        log.info("[idClientePedidos] {}", idClientePedidos);
        PedidosResponse pedidoCriado = pedidosService.criaPedidos(idClientePedidos, pedidosRequest);
        log.info("[finish] PedidosController -  postPedidos");
        return pedidoCriado;
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidosListResponse> buscaPedidosGerais(){
        log.info("[start] PedidosController -  getBuscaPorNumeroPedido");
        List<PedidosListResponse> pedidos = pedidosService.buscaPedidosGerais();
        log.info("[finsih] PedidosController -  getBuscaPorNumeroPedido");
        return pedidos;
    }
    @GetMapping(value = "/{idPedidos}")
    @ResponseStatus(code = HttpStatus.OK)
    PedidosListResponse buscaPorID(@PathVariable UUID idClienteEntrega, @PathVariable UUID idPedidos){
        log.info("[start] PedidosController - buscaPorID");
        log.info("[idClienteEntrega] {} - [idPedidos] {}", idClienteEntrega, idPedidos);
        PedidosListResponse buscaPedido = pedidosService.buscaPorID(idClienteEntrega, idPedidos);
        log.info("[finish] PedidosController - buscaPorID");
        return buscaPedido;
    }
    @PatchMapping(value = "/{idPedidos}")
    @ResponseStatus(code = HttpStatus.OK)
    void alteraPedido(@PathVariable UUID idClienteEntrega, @PathVariable UUID idPedidos,
                                   @Valid @RequestBody PedidosAlteracaoRequest pedidosAlteracaoRequest) {
        log.info("[start] PedidosController - alteraPedido");
        log.info("[idClienteEntrega] {} - [idPedidos] {}",idClienteEntrega, idPedidos);
        pedidosService.alteraPedido(idClienteEntrega, idPedidos, pedidosAlteracaoRequest);
        log.info("[finish] PedidosController - alteraPedido");
    }
    @DeleteMapping(value = "/{idPedidos}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePorID(@PathVariable UUID idClienteEntrega, @PathVariable UUID idPedidos){
        log.info("[start] PedidosController - deletePorID");
        log.info("[idClienteEntrega] {} - [idPedidos] {}",idClienteEntrega, idPedidos);
        pedidosService.deletePorID(idClienteEntrega, idPedidos);
        log.info("[finish] PedidosController - deletePorID");
    }
}

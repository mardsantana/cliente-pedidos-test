package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.service.PedidosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/cliente/pedidos")
@RequiredArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidosResponse postPedidos(@Valid @RequestBody PedidosRequest pedidosRequest) {
        log.info("[start] PedidosController -  postPedidos");
        PedidosResponse pedidoCriado = pedidosService.criaPedidos(pedidosRequest);
        log.info("[finish] PedidosController -  postPedidos");
        return pedidoCriado;
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidosListResponse> buscaPorNumeroPedido(){
        log.info("[start] PedidosController -  getBuscaPorNumeroPedido");
        List<PedidosListResponse> pedidos = pedidosService.buscaPedidosGerais();
        log.info("[finsih] PedidosController -  getBuscaPorNumeroPedido");
        return pedidos;
    }
    @GetMapping(value = "/{numeroPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    PedidosListResponse buscaPorNumeroPedidos(@PathVariable Integer numeroPedido){
        log.info("[start] PedidosController - buscaPorNumeroPedidos");
        PedidosListResponse buscaPedido = pedidosService.buscaPorNumeroPedidos(numeroPedido);
        log.info("[finish] PedidosController - buscaPorNumeroPedidos");
        return buscaPedido;
    }
    @PatchMapping(value = "/{numeroPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    void alteraPedido(@PathVariable Integer numeroPedido,
                                   @Valid @RequestBody PedidosAlteracaoRequest pedidosAlteracaoRequest) {
        log.info("[start] PedidosController - alteraPedido");
        log.info("[numeroPedido] {}", numeroPedido);
        pedidosService.alteraPedido(numeroPedido, pedidosAlteracaoRequest);
        log.info("[finish] PedidosController - alteraPedido");
    }
    @DeleteMapping(value = "/{numeroPeido}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePorNumero(@PathVariable Integer numeroPedido){
        log.info("[start] PedidosController - deletePorNumero");
        log.info("[numeroPedido] {}", numeroPedido);
        pedidosService.deletePorNumeroPedido(numeroPedido);
        log.info("[finish] PedidosController - deletePorNumero");
    }
}

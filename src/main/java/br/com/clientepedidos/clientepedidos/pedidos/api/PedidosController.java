package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
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

    //O método em questão Cria e Salva os Pedidos
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidosResponse postPedidos(@Valid @RequestBody PedidosRequest pedidosRequest) {
        log.info("[start] PedidosController -  postPedidos");
        PedidosResponse pedidoCriado = pedidosService.criaPedidos(pedidosRequest);
        log.info("[finish] PedidosController -  postPedidos");
        return pedidoCriado;
    }
    //O método em questão, busca e lista o pedido pelo número do pedido
    @GetMapping(value = "/{numeroPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidosListResponse> getBuscaPorNumeroPedido(){
        log.info("[start] PedidosController -  getBuscaPorNumeroPedido");
        List<PedidosListResponse> buscaPedidos = pedidosService.buscaPorNumeroPedidos();
        log.info("[finsih] PedidosController -  getBuscaPorNumeroPedido");
        return buscaPedidos;
    }
}
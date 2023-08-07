package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.service.PedidosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Log4j2
@RequestMapping("/cliente/{email}/pedido")
@RequiredArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidosResponse postPedidos(@PathVariable String email, @Valid @RequestBody PedidosRequest pedidosRequest) {
        log.info("[start] PedidosController -  postPedidos");
        log.info("[email] {}", email);
        PedidosResponse pedidoCriado = pedidosService.criaPedido(email, pedidosRequest);
        log.info("[finish] PedidosController -  postPedidos");
        return pedidoCriado;
    }
}

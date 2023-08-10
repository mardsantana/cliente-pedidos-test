package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteList;
import br.com.clientepedidos.clientepedidos.pedidos.service.PedidosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/cliente/pedido")
@RequiredArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;

    @PostMapping(value = "/{email}")
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidosResponse postPedidos(@PathVariable String email,
                                @Valid @RequestBody PedidosRequest pedidosRequest) {
        log.info("[start] PedidosController -  postPedidos");
        log.info("[email] {}", email);
        PedidosResponse pedidoCriado = pedidosService.criaPedidos(email, pedidosRequest);
        log.info("[finish] PedidosController -  postPedidos");
        return pedidoCriado;
    }
    @GetMapping(value = "/{email}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidosList> listaPedidosPorEmail(String email){
        log.info("[start] PedidosController - listaPorEmail");
        List<PedidosList> pedidos = pedidosService.pedidosPorEmail(email);
        log.info("[finish] PedidosController - listaPorEmail");
        return pedidos;
    }
}

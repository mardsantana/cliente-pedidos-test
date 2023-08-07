package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import br.com.clientepedidos.clientepedidos.pedidos.repository.PedidosRespository;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosResponse;
import br.com.clientepedidos.clientepedidos.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidosApplicationService implements PedidosService{

    private final PedidosRespository pedidosRepository;

    private final ClienteService clienteService;

    @Override
    public PedidosResponse criaPedido(String email, PedidosRequest pedidosRequest) {
        log.info("[start] PedidosApplicationService - criaPedido");
        clienteService.clientePorEmail(email);
        Pedidos pedidos = pedidosRepository.savePedidos(new Pedidos(email, pedidosRequest));
        log.info("[finish] PedidosApplicationService - criaPedido");
        return new PedidosResponse(pedidos.getIdPedidos());
    }
}

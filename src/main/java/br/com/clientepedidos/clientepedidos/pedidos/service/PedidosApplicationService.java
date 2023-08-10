package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteList;
import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosList;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import br.com.clientepedidos.clientepedidos.pedidos.repository.PedidosRespository;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosResponse;
import br.com.clientepedidos.clientepedidos.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidosApplicationService implements PedidosService{

    private final PedidosRespository pedidosRepository;

    private final ClienteService clienteService;

    @Override
    public PedidosResponse criaPedidos(String email, PedidosRequest pedidosRequest) {
        log.info("[start] PedidosApplicationService - criaPedido");
        clienteService.clientePorEmail(email);
        Pedidos pedidos = pedidosRepository.savePedidos(new Pedidos(email, pedidosRequest));
        log.info("[finish] PedidosApplicationService - criaPedido");
        return PedidosResponse.builder().idPedidos(pedidos.getIdPedidos()).build();
    }

    @Override
    public List<PedidosList> pedidosPorEmail(String email) {
        log.info("[start] PedidosApplicationService - pedidosPorEmail");
        List<Pedidos> pedidos = pedidosRepository.listaPedidosPorEmail();
        log.info("[finish] PedidosApplicationService - pedidosPorEmail");
        return PedidosList.converte(pedidos);
    }
}

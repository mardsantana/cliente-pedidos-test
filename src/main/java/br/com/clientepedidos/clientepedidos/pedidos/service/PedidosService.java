package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosListResponse;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosResponse;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;

import java.util.List;
import java.util.UUID;

public interface PedidosService {
    PedidosResponse criaPedidos(UUID idClientePedidos, PedidosRequest pedidosRequest);
    List<PedidosListResponse> buscaPedidosGerais();
    PedidosListResponse buscaPorID(UUID idClientePedidos, UUID idPedidos);
    void alteraPedido(UUID idClientePedidos, UUID idPedidos, PedidosAlteracaoRequest pedidosAlteracaoRequest);
    void deletePorID(UUID idClientePedidos, UUID idPedidos);
}

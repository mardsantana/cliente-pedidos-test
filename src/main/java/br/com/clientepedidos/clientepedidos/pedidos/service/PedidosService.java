package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosListResponse;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosResponse;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;

import java.util.List;

public interface PedidosService {
    PedidosResponse criaPedidos(PedidosRequest pedidosRequest);
    List<PedidosListResponse> buscaPedidosGerais();
    PedidosListResponse buscaPorNumeroPedidos(Integer numeroPedido);
    void alteraPedido(Integer numeroPedido, PedidosAlteracaoRequest pedidosAlteracaoRequest);
    void deletePorNumeroPedido(Integer numeroPedido);
}

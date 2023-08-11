package br.com.clientepedidos.clientepedidos.pedidos.api;

import java.util.List;

public interface PedidosService {
    PedidosResponse criaPedidos(PedidosRequest pedidosRequest);
    List<PedidosListResponse> buscaPorNumeroPedidos();
}

package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosResponse;

public interface PedidosService {

    PedidosResponse criaPedido(String email, PedidosRequest pedidosRequest);
}

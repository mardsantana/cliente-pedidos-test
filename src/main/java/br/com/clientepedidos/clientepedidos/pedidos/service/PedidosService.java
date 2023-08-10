package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosList;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosResponse;

import java.util.List;

public interface PedidosService {

    PedidosResponse criaPedidos(String email, PedidosRequest pedidosRequest);
    List<PedidosList> pedidosPorEmail(String email);
}

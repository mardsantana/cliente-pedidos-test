package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;

import java.util.List;

public interface PedidosRepository {
    Pedidos savePedidos(Pedidos pedidos);
    List<Pedidos> buscaPorNumeroPedidos();
}

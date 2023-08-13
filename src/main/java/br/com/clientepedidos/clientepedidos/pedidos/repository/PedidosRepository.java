package br.com.clientepedidos.clientepedidos.pedidos.repository;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;

import java.util.List;

public interface PedidosRepository {
    Pedidos savePedidos(Pedidos pedidos);
    List<Pedidos> buscaPedidosGerais();
    Pedidos buscaPorNumeroPedidos(Integer numeroPedido);
    void deletePedido(Pedidos pedidos);
}

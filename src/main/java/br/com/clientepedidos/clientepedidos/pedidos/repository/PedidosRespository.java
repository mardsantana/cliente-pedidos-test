package br.com.clientepedidos.clientepedidos.pedidos.repository;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;

import java.util.List;

public interface PedidosRespository {
    Pedidos savePedidos(Pedidos pedidos);
    List<Pedidos> listaPedidosPorEmail();
}

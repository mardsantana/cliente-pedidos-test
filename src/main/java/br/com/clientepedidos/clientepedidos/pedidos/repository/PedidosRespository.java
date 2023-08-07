package br.com.clientepedidos.clientepedidos.pedidos.repository;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;

public interface PedidosRespository {
    Pedidos savePedidos(Pedidos pedidos);
}

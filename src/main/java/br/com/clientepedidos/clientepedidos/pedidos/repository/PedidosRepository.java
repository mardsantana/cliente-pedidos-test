package br.com.clientepedidos.clientepedidos.pedidos.repository;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;

import java.util.List;
import java.util.UUID;

public interface PedidosRepository {
    Pedidos savePedidos(Pedidos pedidos);
    List<Pedidos> buscaPedidosGerais();
    Pedidos buscaPorID(UUID idPedidos);
    void deletePedido(Pedidos pedidos);
}

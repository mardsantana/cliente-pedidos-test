package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PedidosListResponse {
    private UUID idPedidos;
    private String pedidos;
    private Integer quantidade;
    private Integer numeroPedido;

    public PedidosListResponse(Pedidos pedidos) {
        this.idPedidos = pedidos.getIdPedidos();
        this.pedidos = pedidos.getPedidos();
        this.quantidade = pedidos.getQuantidade();
        this.numeroPedido = pedidos.getNumeroPedido();
    }
    public static List<PedidosListResponse> converte(List<Pedidos> pedidos) {
            return pedidos.stream()
                    .map(PedidosListResponse::new)
                    .collect(Collectors.toList());
    }
}

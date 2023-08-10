package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class PedidosList {
    private String pedidos;
    private Integer quantidade;
    private Integer numeroPedido;

    public PedidosList(Pedidos pedidos) {
        this.pedidos = pedidos.getPedidos();
        this.quantidade = pedidos.getQuantidade();
        this.numeroPedido = pedidos.getNumeroPedido();
    }
    public static List<PedidosList> converte(List<Pedidos> pedidos) {
        return pedidos.stream()
                .map(PedidosList::new)
                .collect(Collectors.toList());
    }
}

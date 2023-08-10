package br.com.clientepedidos.clientepedidos.pedidos.domain;

import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPedidos;
    private String pedidos;
    private Integer quantidade;
    private Integer numeroPedido;

    public Pedidos(PedidosRequest pedidosRequest) {
        this.pedidos = pedidosRequest.getPedidos();
        this.quantidade = pedidosRequest.getQuantidade();
        this.numeroPedido = pedidosRequest.getNumeroPedido();
    }

    public Pedidos(String email, PedidosRequest pedidosRequest) {
        this.pedidos = pedidosRequest.getPedidos();
        this.quantidade = pedidosRequest.getQuantidade();
        this.numeroPedido = pedidosRequest.getNumeroPedido();
    }
    public Pedidos(Pedidos pedidos) {
        this.pedidos = pedidos.getPedidos();
        this.quantidade = pedidos.getQuantidade();
        this.numeroPedido = pedidos.getNumeroPedido();
    }
}

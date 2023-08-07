package br.com.clientepedidos.clientepedidos.cliente.application.pedidos;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
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
    @NotBlank
    private String pedido;
    @NotBlank
    private String endereco;
    private Integer quantidade;
    private LocalDate dataPedido;
    private Integer numeroPedido;

    public Pedidos(PedidosRequest pedidosRequest) {
        this.pedido = pedidosRequest.getPedido();
        this.endereco = pedidosRequest.getEndereco();
        this.quantidade = pedidosRequest.getQuantidade();
        this.dataPedido = pedidosRequest.getDataPedido();
        this.numeroPedido = pedidosRequest.getNumeroPedido();
    }
}

package br.com.clientepedidos.clientepedidos.cliente.application.pedidos;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Value
public class PedidosRequest {
    private String pedido;
    @NotBlank
    private String endereco;
    private Integer quantidade;
    private LocalDate dataPedido;
    private Integer numeroPedido;
}

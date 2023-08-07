package br.com.clientepedidos.clientepedidos.pedidos.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;


@Value
public class PedidosRequest {

    @NotBlank
    private String pedido;
    private Integer quantidade;
    private Integer numeroPedido;
}

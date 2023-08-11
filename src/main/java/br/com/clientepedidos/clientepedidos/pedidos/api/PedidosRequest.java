package br.com.clientepedidos.clientepedidos.pedidos.api;

import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotBlank;


@Getter
public class PedidosRequest {

    private String pedidos;
    private Integer quantidade;
    private Integer numeroPedido;
}

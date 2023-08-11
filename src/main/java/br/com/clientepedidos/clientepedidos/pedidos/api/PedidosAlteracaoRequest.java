package br.com.clientepedidos.clientepedidos.pedidos.api;

import lombok.Value;

@Value
public class PedidosAlteracaoRequest {
    private String pedidos;
    private Integer quantidade;
}

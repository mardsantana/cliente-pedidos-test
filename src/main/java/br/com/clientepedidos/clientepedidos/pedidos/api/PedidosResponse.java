package br.com.clientepedidos.clientepedidos.pedidos.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PedidosResponse {
    private UUID idPedidos;
}

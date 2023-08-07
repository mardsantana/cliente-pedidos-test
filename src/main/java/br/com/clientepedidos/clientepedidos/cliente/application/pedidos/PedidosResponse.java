package br.com.clientepedidos.clientepedidos.cliente.application.pedidos;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PedidosResponse {
    private UUID idPedidos;
}

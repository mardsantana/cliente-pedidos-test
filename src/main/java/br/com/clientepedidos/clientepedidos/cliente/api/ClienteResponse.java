package br.com.clientepedidos.clientepedidos.cliente.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClienteResponse {
    private UUID idCliente;
}

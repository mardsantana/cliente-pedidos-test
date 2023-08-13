package br.com.clientepedidos.clientepedidos.entregas.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class EntregasResponse {
    private UUID idEntregas;
}

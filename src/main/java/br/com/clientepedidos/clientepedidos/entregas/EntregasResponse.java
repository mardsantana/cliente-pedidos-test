package br.com.clientepedidos.clientepedidos.entregas;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class EntregasResponse {
    private UUID idEntregas;
}

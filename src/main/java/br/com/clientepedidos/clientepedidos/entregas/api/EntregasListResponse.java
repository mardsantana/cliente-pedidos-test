package br.com.clientepedidos.clientepedidos.entregas.api;

import br.com.clientepedidos.clientepedidos.entregas.domain.Entregas;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EntregasListResponse {

    private UUID idEntregas;
    private String nomeRua;
    private Integer numeroCasa;
    private String referencia;

    public EntregasListResponse(Entregas entregas) {
        this.idEntregas = entregas.getIdEntregas();
        this.nomeRua = entregas.getNomeRua();
        this.numeroCasa = entregas.getNumeroCasa();
        this.referencia = entregas.getReferencia();
    }
    public static List<EntregasListResponse> converte(List<Entregas> entregasG) {
        return entregasG.stream()
                .map(EntregasListResponse::new)
                .collect(Collectors.toList());
    }
}

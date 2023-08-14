package br.com.clientepedidos.clientepedidos.entregas.domain;

import br.com.clientepedidos.clientepedidos.entregas.api.EntregasAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Data
@ToString
public class Entregas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEntregas;
    @NotBlank
    private String nomeRua;
    private Integer numeroCasa;
    @NotBlank
    private String referencia;

    public Entregas(EntregasRequest entregasRequest) {
        this.nomeRua = entregasRequest.getNomeRua();
        this.numeroCasa = entregasRequest.getNumeroCasa();
        this.referencia = entregasRequest.getReferencia();
    }

    public void altera(EntregasAlteracaoRequest entregasAlteracaoRequest) {
        this.nomeRua = entregasAlteracaoRequest.getNomeRua();
        this.numeroCasa = entregasAlteracaoRequest.getNumeroCasa();
        this.referencia = entregasAlteracaoRequest.getReferencia();
    }
}

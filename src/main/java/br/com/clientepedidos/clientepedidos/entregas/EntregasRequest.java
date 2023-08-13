package br.com.clientepedidos.clientepedidos.entregas;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class EntregasRequest {
    @NotBlank
    private String nomeRua;
    private Integer numeroCasa;
    @NotBlank
    private String referencia;
}

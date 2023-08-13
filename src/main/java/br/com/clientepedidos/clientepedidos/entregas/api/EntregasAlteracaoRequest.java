package br.com.clientepedidos.clientepedidos.entregas.api;

import lombok.Value;



@Value
public class EntregasAlteracaoRequest {

    private String nomeRua;
    private Integer numeroCasa;
    private String referencia;
}

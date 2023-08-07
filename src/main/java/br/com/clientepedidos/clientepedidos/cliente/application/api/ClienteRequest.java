package br.com.clientepedidos.clientepedidos.cliente.application.api;

import br.com.clientepedidos.clientepedidos.cliente.application.pedidos.PedidosRequest;
import br.com.clientepedidos.clientepedidos.cliente.domain.Sexo;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private List<PedidosRequest> pedidos;

}

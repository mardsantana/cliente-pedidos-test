package br.com.clientepedidos.clientepedidos.cliente.api;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.Getter;

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

    private List<Pedidos> pedidos;

}

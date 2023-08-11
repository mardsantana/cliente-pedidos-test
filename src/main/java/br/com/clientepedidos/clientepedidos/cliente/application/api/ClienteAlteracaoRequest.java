package br.com.clientepedidos.clientepedidos.cliente.application.api;


import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.Value;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Value
public class ClienteAlteracaoRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
}

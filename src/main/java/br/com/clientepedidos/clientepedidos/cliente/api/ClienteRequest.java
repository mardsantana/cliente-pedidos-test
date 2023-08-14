package br.com.clientepedidos.clientepedidos.cliente.api;


import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
}

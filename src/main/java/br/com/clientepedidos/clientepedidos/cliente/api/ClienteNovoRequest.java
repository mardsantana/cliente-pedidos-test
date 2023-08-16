package br.com.clientepedidos.clientepedidos.cliente.api;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class ClienteNovoRequest {
    @NotBlank
    @Email
    private String email;
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @NotBlank
    private String senha;
}

package br.com.clientepedidos.clientepedidos.cliente.domain;


import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.email = clienteRequest.getEmail();
        this.telefone = clienteRequest.getTelefone();
        this.sexo = clienteRequest.getSexo();
    }

    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nomeCompleto = clienteAlteracaoRequest.getNomeCompleto();
        this.email = clienteAlteracaoRequest.getEmail();
        this.telefone = clienteAlteracaoRequest.getTelefone();
        this.sexo = clienteAlteracaoRequest.getSexo();
    }
}

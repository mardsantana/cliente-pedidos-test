package br.com.clientepedidos.clientepedidos.cliente.domain;


import br.com.clientepedidos.clientepedidos.cliente.api.ClienteAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.cliente.api.ClienteRequest;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.*;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Data
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
    @Email
    private String email;
    @NotBlank
    private String telefone;

    public Cliente(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.senha = clienteRequest.getSenha();
        this.email = clienteRequest.getEmail();
        this.telefone = clienteRequest.getTelefone();
    }
    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nome = clienteAlteracaoRequest.getNome();
        this.email = clienteAlteracaoRequest.getEmail();
        this.telefone = clienteAlteracaoRequest.getTelefone();
    }
}

package br.com.clientepedidos.clientepedidos.cliente.domain;


import br.com.clientepedidos.clientepedidos.cliente.api.ClienteAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.cliente.api.ClienteRequest;
import br.com.clientepedidos.clientepedidos.entregas.EntregasRequest;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.*;

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
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedidos> pedidos;

    public Cliente(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.email = clienteRequest.getEmail();
        this.telefone = clienteRequest.getTelefone();
        this.pedidos = clienteRequest.getPedidos()
                .stream()
                .map(Pedidos::new)
                .collect(Collectors.toList());
    }
    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nome = clienteAlteracaoRequest.getNome();
        this.email = clienteAlteracaoRequest.getEmail();
        this.telefone = clienteAlteracaoRequest.getTelefone();
    }
}

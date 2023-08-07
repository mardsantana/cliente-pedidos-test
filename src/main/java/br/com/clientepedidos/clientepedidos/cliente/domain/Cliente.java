package br.com.clientepedidos.clientepedidos.cliente.domain;


import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.api.ClienteRequest;
import br.com.clientepedidos.clientepedidos.cliente.application.pedidos.Pedidos;
import br.com.clientepedidos.clientepedidos.cliente.application.pedidos.PedidosRequest;
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
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedidos> pedidos;

    public Cliente(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.email = clienteRequest.getEmail();
        this.telefone = clienteRequest.getTelefone();
        this.sexo = clienteRequest.getSexo();
        this.pedidos = clienteRequest.getPedidos()
                .stream()
                .map(Pedidos::new)
                .collect(Collectors.toList());
    }
    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nome = clienteAlteracaoRequest.getNome();
        this.email = clienteAlteracaoRequest.getEmail();
        this.telefone = clienteAlteracaoRequest.getTelefone();
        this.sexo = clienteAlteracaoRequest.getSexo();
    }
}

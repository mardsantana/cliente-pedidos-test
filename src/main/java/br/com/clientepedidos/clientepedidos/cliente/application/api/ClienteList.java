package br.com.clientepedidos.clientepedidos.cliente.application.api;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.Value;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteList {
    private UUID idCliente;
    private String nome;
    private String email;
    private String telefone;
    private List<Pedidos> pedidos;

    public ClienteList(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.pedidos = cliente.getPedidos();
    }
    public static List<ClienteList> converte(List<Cliente> cliente) {
        return cliente.stream()
                .map(ClienteList::new)
                .collect(Collectors.toList());
    }

}

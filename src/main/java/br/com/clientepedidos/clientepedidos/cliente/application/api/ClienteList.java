package br.com.clientepedidos.clientepedidos.cliente.application.api;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import br.com.clientepedidos.clientepedidos.cliente.domain.Sexo;
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
    private Sexo sexo;

    public ClienteList(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.sexo = cliente.getSexo();
    }
    public static List<ClienteList> converte(List<Cliente> cliente) {
        return cliente.stream().map(ClienteList::new).collect(Collectors.toList());
    }
}

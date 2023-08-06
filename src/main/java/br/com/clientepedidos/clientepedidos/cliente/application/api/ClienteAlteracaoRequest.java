//package br.com.clientepedidos.clientepedidos.cliente.application.api;
//
//
//import br.com.clientepedidos.clientepedidos.cliente.domain.Sexo;
//import lombok.Value;
//
//import javax.persistence.Column;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//
//@Value
//public class ClienteAlteracaoRequest {
//    @NotBlank
//    private String nomeCompleto;
//    @NotBlank
//    @Email
//    @Column(unique = true)
//    private String email;
//    @NotBlank
//    private String telefone;
//    @Enumerated(EnumType.STRING)
//    private Sexo sexo;
//}

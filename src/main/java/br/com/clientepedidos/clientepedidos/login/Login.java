package br.com.clientepedidos.clientepedidos.login;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLogin;
    @NotBlank
    @Email
    private String email;
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @NotBlank
    private String senha;
}

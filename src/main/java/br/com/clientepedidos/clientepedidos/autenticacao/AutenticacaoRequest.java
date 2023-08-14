package br.com.clientepedidos.clientepedidos.autenticacao;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class AutenticacaoRequest {
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @NotBlank
    private String senha;
    @Email
    private String email;

    public UsernamePasswordAuthenticationToken getSenhaToken() {
        return new UsernamePasswordAuthenticationToken(senha, email);
    }
}

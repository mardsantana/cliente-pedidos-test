package br.com.clientepedidos.clientepedidos.autenticacao;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Token {
    private String token;
}

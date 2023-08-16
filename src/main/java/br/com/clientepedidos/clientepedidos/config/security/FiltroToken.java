package br.com.clientepedidos.clientepedidos.config.security;

import br.com.clientepedidos.clientepedidos.config.security.domain.ValidaConteudoAuthorizationHeader;
import br.com.clientepedidos.clientepedidos.config.security.service.TokenService;
import br.com.clientepedidos.clientepedidos.credencial.application.service.CredencialApplicationService;
import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;
import br.com.clientepedidos.clientepedidos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
public class FiltroToken extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final CredencialApplicationService credencialService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("[inicio] Filtro - filtrando requisicao");
        String token = recuperaToken(request);
        autenticaCliente(token);
        log.info("[finaliza] Filtro - filtrando requisicao");
        filterChain.doFilter(request, response);
    }

    private void autenticaCliente(String token) {
        log.info("[inicio] autenticacaoCliente - utilizando token válido para autenticar o usuário");
        Credencial credencial = recuperaUsuario(token);
        var authenticationToken = new UsernamePasswordAuthenticationToken(credencial, null, credencial.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("[finaliza] autenticacaoCliente - utilizando token válido para autenticar o usuário");
    }

    private Credencial recuperaUsuario(String token) {
        var usuario = tokenService.getUsuario(token).orElseThrow(()-> APIException.build(HttpStatus.FORBIDDEN,"O Token enviado está inválido. Tente novamente."));
        return credencialService.buscaCredencialPorUsuario(usuario);
    }

    private String recuperaToken(HttpServletRequest requestOpt) {
        log.info("[inicio] recuperaToken - extraindo o token dos cabecalhos da requisicao");
        var AuthorizationHeaderValueOpt = Optional.ofNullable(recuperaValorAuthorizationHeader(requestOpt));
        String AuthorizationHeaderValue = AuthorizationHeaderValueOpt.filter(new ValidaConteudoAuthorizationHeader())
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        log.info("[finaliza] recuperaToken - extraindo o token dos cabecalhos da requisicao");
        return AuthorizationHeaderValue.substring(7, AuthorizationHeaderValue.length());
    }

    private String recuperaValorAuthorizationHeader(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .orElseThrow(() -> APIException.build(HttpStatus.FORBIDDEN, "Token não está presente na requisição!"));
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.contains("/public/")||path.contains("/swagger-ui/");
    }

}

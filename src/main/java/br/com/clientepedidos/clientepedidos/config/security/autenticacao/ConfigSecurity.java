package br.com.clientepedidos.clientepedidos.config.security.autenticacao;

import br.com.clientepedidos.clientepedidos.filtros.AutendicadorRequest;
import br.com.clientepedidos.clientepedidos.filtros.FiltroAutenticacaoJWTToken;
import br.com.clientepedidos.clientepedidos.filtros.FiltroAutenticadorJWTToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class ConfigSecurity {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }))
                .addFilterBefore(new AutendicadorRequest(), BasicAuthenticationFilter.class)
                .addFilterAfter(new FiltroAutenticadorJWTToken(), BasicAuthenticationFilter.class)
                .addFilterBefore(new FiltroAutenticacaoJWTToken(), BasicAuthenticationFilter.class)
                .authorizeRequests(requests -> {
                            try {
                                requests
                                        .antMatchers("/cadastro").permitAll()
                                        .antMatchers("/entrega").authenticated()
                                        .antMatchers("/cliente").authenticated()
                                        .antMatchers("/produto").authenticated()
                                        .antMatchers("/pedido").authenticated()
                                        .antMatchers("/login/auth").authenticated()
                                        .and().csrf().disable();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}


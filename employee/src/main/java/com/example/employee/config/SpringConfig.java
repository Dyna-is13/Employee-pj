package com.example.employee.config;

import com.example.employee.exception.CustomAccessDenied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@Configuration
public class SpringConfig {

    @Value("${JWK_SET_URI}")
    private String jwkSetUri;

    private  String[] AUTH_WHITE_LIST = {"/v3/api-docs/**","/swagger-resources/**","/swagger-ui/**"};


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new CustomJwtAuthenticationConverter());
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequest ->
                        authorizeHttpRequest
                               // .requestMatchers("/employees/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/employees/**").permitAll()
                                .requestMatchers(AUTH_WHITE_LIST).permitAll()
                                .requestMatchers("/web/**").permitAll())
//                                .requestMatchers("/employees/**").authenticated())
//                                .requestMatchers("/employees/**").hasRole("ADMIN"))
                .oauth2ResourceServer(
                        oauthResourceServer ->
                                oauthResourceServer.accessDeniedHandler(new CustomAccessDenied())
                                        .authenticationEntryPoint(new CustomAuthenticateEntryPoint())
                                        .jwt(jwt ->
                                                jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)
                                                        .decoder(jwtDecoder())))
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(STATELESS));
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }
}

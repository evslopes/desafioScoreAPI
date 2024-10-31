package jhhdev.api.score.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserDetailsService userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll() // Permite acesso ao endpoint de autenticação
                .requestMatchers("/api/auth/login").permitAll() // Permite acesso ao endpoint de autenticação
                .requestMatchers("/swagger-ui/**").permitAll() // Permite acesso ao Swagger UI
                .requestMatchers("/v3/api-docs/**").permitAll() // Permite acesso à documentação da API
                .requestMatchers("/swagger-resources/**").permitAll() // Permite acesso aos recursos do Swagger
                .requestMatchers("/api-docs/**").permitAll() // Permite acesso aos webjars do Swagger
                .requestMatchers("/webjars/**").permitAll() // Permite acesso aos webjars do Swagger
                .requestMatchers("/h2-console/**").permitAll() // Permite acesso ao console H2
                .requestMatchers("/api/pessoas/**").hasRole("ADMIN") // Restrição para ADMIN no CRUD de Pessoa
                .requestMatchers("/api/pessoas/listar").hasAnyRole("USER", "ADMIN") // Permite listagem para USER e ADMIN
                .anyRequest().authenticated() // Requer autenticação para outras requisições
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Configura o gerenciamento de sessão

        // Adiciona o filtro de autenticação JWT antes do UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package co.com.gm.web;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration

@EnableWebSecurity

public class SecurityConfig{



    //PERMISOS

    @Autowired

    private UserDetailsService UserDetailsService;



    //@Bean

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Autowired
    public void configure(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(UserDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Operation(summary = "Login", description = "Login.")
    //AUTORIZACION
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 
        http
                .authorizeHttpRequests(authorize  -> authorize 
                .requestMatchers("/webjars/**", "/js/**", "/images/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll() // Permitir acceso a recursos estáticos  
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar")
                        
                // solo el admin entran a realizar las configuraciones anteriores
                .hasRole("ADMIN")
                .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling(ex -> ex.accessDeniedPage("/errores/403"));
 
        return http.build();
 
//            
    }
}
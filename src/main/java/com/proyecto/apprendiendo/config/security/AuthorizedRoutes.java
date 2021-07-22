package com.proyecto.apprendiendo.config.security;

import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.services.FindUserDetailsService;
import com.proyecto.apprendiendo.services.JwtTokenFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class AuthorizedRoutes extends WebSecurityConfigurerAdapter {
    private final JwtTokenFilter jwtTokenFilter;
    private final FindUserDetailsService findUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(findUserDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, ex) ->
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage()))
                .and();

        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/register/student", "/register/teacher").hasAnyRole(UserType.ADMIN.getValue())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successForwardUrl("/")
                .and()
                .httpBasic();

        http.addFilterBefore(
                jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }
}

package com.proyecto.apprendiendo.services;

import com.proyecto.apprendiendo.config.security.JwtTokenUtil;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetUserDetailsService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
@AllArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final GetUserDetailsService getUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        String token = header.substring(7);
        if(isEmpty(token)) {
            chain.doFilter(request, response);
            return;
        }
        String username = jwtTokenUtil.getUsernameFromToken(token);
        if(isEmpty(username)) {
            chain.doFilter(request, response);
            return;
        }
        // Get user identity and set it on the spring security context
        UserDetails userDetails = getUserDetailsService.loadUserByUsername(username);
        // Get jwt token and validate
        if (!jwtTokenUtil.validateToken(token, userDetails) || SecurityContextHolder.getContext().getAuthentication() != null) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }




}

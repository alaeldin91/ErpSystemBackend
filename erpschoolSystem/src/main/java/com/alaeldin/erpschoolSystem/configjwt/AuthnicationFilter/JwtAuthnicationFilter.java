package com.alaeldin.erpschoolSystem.configjwt.AuthnicationFilter;


import com.alaeldin.erpschoolSystem.configjwt.service.JwtService;
import com.alaeldin.erpschoolSystem.security.repository.role.RoleRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Configuration
@AllArgsConstructor
public class JwtAuthnicationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("authorization");
        final String jwt;
        Object role;

        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        jwt = authHeader.substring(7);

        userEmail = jwtService.extractEmail(jwt);
        role = jwtService.getRole(jwt);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
               UserDetails userDetails =  userDetailsService.loadUserByUsername(userEmail);

            //String authorizes = StringUtils.collectionToCommaDelimitedString(userDetails.getAuthorities());
            List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role.toString()));
             if (jwtService.isTokenValid(jwt,userDetails)){
                   UsernamePasswordAuthenticationToken authenticationToken =
                           new UsernamePasswordAuthenticationToken(userDetails
                                   ,null
                                   ,authorities);
                   authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
               }
        }
        filterChain.doFilter(request,response);
    }
}

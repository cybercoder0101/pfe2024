package com.pfe.code.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader("Authorization");

        if (jwt == null || !jwt.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);

            System.out.println("lol");
            System.out.println(jwt);
            return;
        }

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecParams.Secret)).build();
        jwt = jwt.substring(SecParams.n);

        DecodedJWT decodedJWT = verifier.verify(jwt);
        String username = decodedJWT.getSubject();
      String role = decodedJWT.getClaim("role").asString();

        if (username != null && role !=null) {
          GrantedAuthority authority = new SimpleGrantedAuthority(role);
          Collection<GrantedAuthority>authorities = Collections.singletonList(authority);


            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }
}

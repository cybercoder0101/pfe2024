package com.pfe.code.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.code.entities.Utilisateur;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {


        super();
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        Utilisateur utilisateur = new Utilisateur();
        try {
            utilisateur = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
            System.out.println("json error");
        } catch (JsonMappingException e) {
            System.out.println("parsing error");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("exception");
            e.printStackTrace();
        }
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(utilisateur.getEmail(), utilisateur.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException
    {

        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
   String role = springUser.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElse(null);

        String jwt = JWT.create().
                withSubject(springUser.getUsername()).
                withClaim("role", role).
                withExpiresAt(new Date(System.currentTimeMillis()+SecParams.EXP_TIME)).
                sign(Algorithm.HMAC256(SecParams.Secret));
        response.addHeader("Authorization", jwt);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {
        if (failed instanceof DisabledException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            Map<String, Object> data = new HashMap<>();

            data.put("errorCause", "désactivé");
            data.put("message", "L'utilisateur n'est pas connecté !");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(data);
            PrintWriter writer = response.getWriter();
            writer.println(json);
            writer.flush();

        } else {
            super.unsuccessfulAuthentication(request, response, failed);
        }
    }

}

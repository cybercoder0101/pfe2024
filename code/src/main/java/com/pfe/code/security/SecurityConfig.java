package com.pfe.code.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            "/",
            "/api/v1/auth/**",
            "/api-docs",
            "/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/swagger-ui/index.html#/**",
            "/v3/api-docs/swagger-config/**",
            "/v3/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
    private static final String[] AdminList={"/all","/deleteUser","/nomcont","/supprimer/**","/addSl","addFournisseur","/marchands"};
    private static final String [] Service={"/getSl",
            "/deleteSL",
            "/updateSl",
            "/getbyid",
            "/getforsl",
            "/addlivreur",
            "/updateL"};
    private static final String [] commun={"/changepassword",
            "/updateinfosuser",
            "/email",
            "/categories",
            "/etats",
            "/images",
            "/souscategories",
            "/users"};
    private static final String [] Livreur={"/updateL",
            "/deletelivreur",
            "/getforsl"};
    private static final String [] Fournisseur={"/addprod",
            "/update",
            "/supprimer",
};



    @Autowired
    AuthenticationManager authMgr;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    {
        http.sessionManagement( session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration cors1 = new CorsConfiguration();

                    cors1.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    cors1.setAllowedMethods(Collections.singletonList("*"));
                    cors1.setAllowCredentials(true);
                    cors1.setAllowedHeaders(Collections.singletonList("*"));
                    cors1.setExposedHeaders(Collections.singletonList("Authorization"));
                    cors1.setMaxAge(3600L);
                    return cors1;
                }))
                .authorizeHttpRequests( authorize -> authorize
                        .requestMatchers(AUTH_WHITELIST).permitAll()

                        .requestMatchers(
                                "baba/login",
                                "baba/marchands/register",
                                "baba/marchands/verifyEmail/**",
                                "/swagger-ui/**" ,
                                "/produits/**",
                                "/etats/**",
                                "/images/**",
                                "/souscategories/**",
                                "/categories/**",
                                "/commandes/newcommande/**"
                                ).permitAll()


                        .requestMatchers(commun).permitAll()
                        .requestMatchers(AdminList).hasAuthority("ADMIN")
                        .requestMatchers(Service).hasAuthority("SERVICE_LIVRAISON")
                        .requestMatchers(Livreur).hasAuthority("LIVREUR")
                        .requestMatchers(Fournisseur).hasAuthority("FOURNISSEUR")
                        .anyRequest().authenticated()



                )


                .addFilterBefore(new JWTAuthenticationFilter(authMgr),UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class)


                ;

        return http.build();
    }

}

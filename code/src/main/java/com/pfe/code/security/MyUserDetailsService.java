package com.pfe.code.security;

import com.pfe.code.entities.Marchand;
import com.pfe.code.entities.Utilisateur;
import com.pfe.code.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur= userService.findByEmail(email);
        if (utilisateur==null){
            throw new UsernameNotFoundException("Utilisateur introuvable !");
        }
        List<GrantedAuthority>auths= new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(utilisateur.getRole().name());
        auths.add(authority);
        if (utilisateur instanceof Marchand marchand){
            return new org.springframework.security.core.userdetails.User(utilisateur.getEmail(), utilisateur.getPassword(),marchand.isIsactive(),true,true,true, auths);

        }
        else {
            return new org.springframework.security.core.userdetails.User(utilisateur.getEmail(),utilisateur.getPassword(),true,true,true,true,auths);
        }
    }
}

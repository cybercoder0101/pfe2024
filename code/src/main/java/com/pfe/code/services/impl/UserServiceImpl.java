package com.pfe.code.services.impl;

import com.pfe.code.entities.Utilisateur;
import com.pfe.code.repositories.UtilisateurRepository;
import com.pfe.code.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Override
    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public List<Utilisateur> getByNomcontains(String nom) {
        return utilisateurRepository.findByNomContains(nom);
    }
}

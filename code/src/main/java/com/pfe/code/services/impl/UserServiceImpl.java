package com.pfe.code.services.impl;

import com.pfe.code.entities.Utilisateur;
import com.pfe.code.repositories.UtilisateurRepository;
import com.pfe.code.services.Exceptions.GlobalException;
import com.pfe.code.services.UserService;
import com.pfe.code.services.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    EmailSender emailSender;
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

    @Override
    public Utilisateur changepasseword(Long id,String change) {
        Optional<Utilisateur>optional = utilisateurRepository.findById(id);
        if (optional.isEmpty())
            throw new GlobalException("Utilisateur non trouvé ");
        optional.get().setPassword(change);


        return utilisateurRepository.save(optional.get());
    }

    @Override
    public void deleteUserByid(Long id) {
        utilisateurRepository.deleteById(id);
    }
}

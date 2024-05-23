package com.pfe.code.services;

import com.pfe.code.entities.Utilisateur;

import java.util.List;

public interface UserService {
    List<Utilisateur> getAll();
    Utilisateur getByEmail(String email);
    List<Utilisateur> getByNomcontains(String nom);
    Utilisateur changepasseword(Long id,String change);

    void deleteUserByid(Long id);

}

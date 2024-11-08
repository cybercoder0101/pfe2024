package com.pfe.code.services;

import com.pfe.code.entities.Utilisateur;

import java.util.List;
//principe SRP
public interface UserService {
    List<Utilisateur> getAll();
    Utilisateur getByEmail(String email);
    List<Utilisateur> getByNomcontains(String nom);
    Utilisateur changepasseword(Long id,String change);
Utilisateur findByEmail(String email);
    void deleteUserByid(Long id);

    Utilisateur updateinfos(Utilisateur utilisateur);

}

package com.pfe.code.services;

import com.pfe.code.entities.Categorie;

import java.util.List;
//principe SRP
public interface CategorieService {
    Categorie saveCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    Categorie getCategorie(Long id);
    void deleteCategorie(Long id);
    List<Categorie> getAll();
    List<Categorie> getByNomC(String nom);

    List<String>getnoms();
}

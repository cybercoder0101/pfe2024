package com.pfe.code.services;

import com.pfe.code.entities.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie saveCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    void deleteCategorie(Long id);
    List<Categorie> getAll();
    List<Categorie> getByNomC(String nom);

    List<String>getnoms();
}

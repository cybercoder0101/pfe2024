package com.pfe.code.services;

import com.pfe.code.entities.SousCategorie;
import com.pfe.code.repositories.SousCategorieRepository;

import java.util.List;

public interface SousCategorieService {
    SousCategorie saveSousCategorie(Long id,SousCategorie sousCategorie);
    SousCategorie updateSousCategorie(SousCategorie sousCategorie);
    SousCategorie getSousCategorie(Long id);
    void deleteSousCategorie(Long id);
    List<SousCategorie> getAll();
    List<SousCategorie>getByNomC(String nom);
    List<String>getnomSC();
}
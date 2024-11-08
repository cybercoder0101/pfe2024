package com.pfe.code.services;

import com.pfe.code.entities.SousCategorie;
import com.pfe.code.repositories.SousCategorieRepository;

import java.util.List;
//principe SRP
public interface SousCategorieService {
    SousCategorie saveSousCategorie(Long id,SousCategorie sousCategorie);
    SousCategorie updateSousCategorie(SousCategorie sousCategorie);
    List<SousCategorie>getByCategorieId(Long id);
    SousCategorie getSousCategorie(Long id);
    void deleteSousCategorie(Long id);
    List<SousCategorie> getAll();
    List<SousCategorie>getByNomC(String nom);
    List<String>getnomSC();
    SousCategorie getById(Long id);
}

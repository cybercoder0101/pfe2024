package com.pfe.code.services;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FourniseurService {
    List<Fournisseur>getAll();

    List<Fournisseur>getByNomContains(String nom);
    Fournisseur saveFournisseur(Fournisseur fournisseur);
    void deleteFournisseurById(Long id);
    Produit saveProd(Produit produit);
}

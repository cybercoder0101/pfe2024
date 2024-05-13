package com.pfe.code.services;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;

import java.util.List;
import java.util.Optional;


public interface FourniseurService {
    List<Fournisseur>getAll();
    Fournisseur saveFournisseur(Fournisseur fournisseur);

    Fournisseur getByid(Long id) throws Exception;


    List<Fournisseur>getByNomContains(String nom);
    List<Fournisseur>getByNomACS();
    List<Fournisseur>getByNomDESC();
    List<Fournisseur>getByPreAcs();

    Optional<Fournisseur> findByEmail(String email);

    List<Fournisseur>getByPreDesc();

    void deleteFournisseurById(Long id);

    Fournisseur updateinfoFour(Long id, Fournisseur fournisseurUp);
    Fournisseur updateFourbyid(Long id, Produit produit);


}

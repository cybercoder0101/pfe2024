package com.pfe.code.services;

import com.pfe.code.entities.Administrateur;
import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;

import java.util.List;
import java.util.Optional;


public interface FournisseurService {
    List<Fournisseur>getAll();
    List<String>getAllnoms();
    Fournisseur saveFournisseur(Fournisseur fournisseur);

    Fournisseur getByid(Long id) ;
    List<Fournisseur>findByAdresse_Pays(String pays);


    List<Fournisseur>getByNomContains(String nom);
    List<Fournisseur>getByNomACS();
    List<Fournisseur>getByNomDESC();
    List<Fournisseur>getByPreAcs();

    Optional<Fournisseur> findByEmail(String email);

   Administrateur addadmin(Administrateur administrateur);

    List<Fournisseur>getByPreDesc();

    void deleteFournisseurById(Long id);

    Fournisseur updateinfoFour( Fournisseur fournisseurUp);
    Fournisseur updateFourbyid(Long id, Produit produit);


}

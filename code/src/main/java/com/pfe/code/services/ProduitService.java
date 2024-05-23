package com.pfe.code.services;


import com.pfe.code.entities.Produit;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitService {
    List<Produit> getAll();
    Produit saveProduit(Produit produit);
    Produit updateProduit(Produit produit);
    List<Produit>findProd(String terme);
    Produit getProd(Long id);
    List<Produit> getByfournisseur(Long id);

    List<Produit> filtre(Double minPrix,Double maxPrix, List<String>categories, List<String>souscategories,Long quantiteMin, Long quantiteMax);
    void deleteById(Long id);

    List<Produit>findbynomcontains(String nom);

    List<Produit>findByNomCat(String nomCat);

    List<Produit>categorieAcs();
    List<Produit>categorieDesc();

    List<Produit>findbycategorieId(Long id);

    List<Produit>findprixProd(Double prixProd);

    List<Produit>OrderprixA();

    List<Produit>OrderprixD();

    List<Produit>findprixbetween(Double p1, Double p2);


    List<Produit> OrderByNomasc();


    List<Produit> OrderByNomdesc();






}

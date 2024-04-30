package com.pfe.code.services;


import com.pfe.code.entities.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAll();
    Produit saveProduit(Produit produit);
    Produit updateProduit(Produit produit);
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






}

package com.pfe.code.services;


import com.pfe.code.entities.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAll();
    Produit saveProduit(Produit produit);

}

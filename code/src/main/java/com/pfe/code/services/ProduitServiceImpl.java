package com.pfe.code.services;

import com.pfe.code.entities.Produit;
import com.pfe.code.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }
}

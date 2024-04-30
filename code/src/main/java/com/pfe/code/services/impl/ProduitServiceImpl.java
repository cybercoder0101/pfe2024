package com.pfe.code.services.impl;

import com.pfe.code.entities.Produit;
import com.pfe.code.repositories.ProduitRepository;
import com.pfe.code.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {
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

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> findbynomcontains(String nom) {
        return produitRepository.findByNomProdContains(nom);
    }

    @Override
    public List<Produit> findByNomCat(String nomCat) {
        return produitRepository.findByCategorie(nomCat);
    }

    @Override
    public List<Produit> categorieAcs() {
        return produitRepository.OrderedByCategorieAsc();
    }

    @Override
    public List<Produit> categorieDesc() {
        return produitRepository.orderByCategorieDesc();
    }

    @Override
    public List<Produit> findbycategorieId(Long id) {
        return produitRepository.findByCategorieId(id);
    }

    @Override
    public List<Produit> findprixProd(Double prixProd) {
        return produitRepository.findByPrixProd(prixProd);
    }

    @Override
    public List<Produit> OrderprixA() {
        return produitRepository.OrderByPrixA();
    }

    @Override
    public List<Produit> OrderprixD() {
        return produitRepository.OrderByPrixD();
    }

    @Override
    public List<Produit> findprixbetween(Double p1, Double p2) {
        return produitRepository.findByPrixProdBetween(p1,p2);
    }
}

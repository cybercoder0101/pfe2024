package com.pfe.code.services;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;
import com.pfe.code.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FourniseurServiceImpl implements FourniseurService{
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Autowired
    ProduitService produitService;

    @Override
    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    @Override
    public List<Fournisseur> getByNomContains(String nom) {
        return fournisseurRepository.findByNomContains(nom);
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseurById(Long id) {
        fournisseurRepository.deleteById(id);

    }

    @Override
    public Produit saveProd(Produit produit) {
        return produitService.saveProduit(produit);
    }
}

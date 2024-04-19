package com.pfe.code.services;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FourniseurServiceImpl implements FourniseurService{
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseurById(Long id) {
        fournisseurRepository.deleteById(id);

    }
}

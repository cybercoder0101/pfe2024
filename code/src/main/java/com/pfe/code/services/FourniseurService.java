package com.pfe.code.services;

import com.pfe.code.entities.Fournisseur;
import org.springframework.stereotype.Service;


public interface FourniseurService {
    Fournisseur saveFournisseur(Fournisseur fournisseur);
    void deleteFournisseurById(Long id);
}

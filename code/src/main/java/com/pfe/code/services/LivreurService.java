package com.pfe.code.services;

import com.pfe.code.entities.Livreur;

import java.util.List;

public interface LivreurService {
    List<Livreur> getAll();
    Livreur getByid(Long id);
    Livreur updateLivreur(Livreur livreur);
    List<Livreur> getForServiceLivraison(Long id);
    void deleteLivreur(Long id);
}

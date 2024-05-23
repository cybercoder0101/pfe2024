package com.pfe.code.services;

import com.pfe.code.entities.Livreur;

import java.util.List;

public interface LivreurService {
    Livreur createLivreur(Long id,Livreur livreur);
    List<Livreur> getAll();
    Livreur getByid(Long id);
    Livreur updateLivreur(Livreur livreur);
    List<Livreur> getForServiceLivraison(Long id);
    void deleteLivreur(Long id);
}

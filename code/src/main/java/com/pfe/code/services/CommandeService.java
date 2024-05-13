package com.pfe.code.services;

import com.pfe.code.entities.Commande;
import com.pfe.code.entities.Etat;

import java.util.List;

public interface CommandeService {
    List<Commande> findAll();
    List<Commande>findByMarchandId(Long id);
    List<Commande>findBySLId(Long id);
    Commande findByref(String ref);
    List<Commande>findByLivreurId(Long id);
    Commande createCommande(Long idM,Long idSL,Long idP,Commande commande);
    Commande setLivreurCommande(Long idCom, Long idLivreur);
    Commande updateEtat(Long idCom, Etat etat);

    void deleteCommandeById(Long id);

}

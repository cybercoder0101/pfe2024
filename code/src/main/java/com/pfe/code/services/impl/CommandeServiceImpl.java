package com.pfe.code.services.impl;

import com.pfe.code.entities.*;
import com.pfe.code.repositories.*;
import com.pfe.code.services.CommandeService;
import com.pfe.code.services.MarchandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service

public class CommandeServiceImpl implements CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    MarchandRepository marchandRepository;

    @Autowired
    ServiceLivraisonRepository serviceLivraisonRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    LivreurRepository livreurRepository;


    public String generateCommandeReference(String nomMarchand, String nomSL,String date) {

        String m = nomMarchand.substring(0, Math.min(nomMarchand.length(), 2));
        String sl= nomSL.substring(0,Math.min(nomMarchand.length(), 2));

        String ref= m+sl+date;

        return ref;
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    @Override
    public List<Commande> findByMarchandId(Long id) {
        return commandeRepository.findByMarchandId(id);
    }

    @Override
    public List<Commande> findBySLId(Long id) {
        return commandeRepository.findByServiceLivraisonId(id);
    }

    @Override
    public Commande findByref(String ref) {
        return commandeRepository.findByReference(ref);
    }

    @Override
    public List<Commande> findByLivreurId(Long id) {
        return commandeRepository.findByLivreurId(id);
    }

    @Override
    public Commande createCommande(Long idM,Long idSL,Long idP ,Commande commande) {


//        LocalDate date= LocalDate.now();
//
//        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
//
//        Marchand marchand = marchandRepository.findById(idM).get();
//        ServiceLivraison serviceLivraison= serviceLivraisonRepository.findById(idSL).get();
//        Produit produit= produitRepository.findById(idP).get();
//        commande.setProduit(produit);
//        commande.setDateCommande(sqlDate);
//        String ref= generateCommandeReference(marchand.getNom(),serviceLivraison.getNom(), commande.getDateCommande().toString());
//        commande.setReference(ref);
//        commande.setPrixT((long) (commande.getQuantité()*produit.getPrixProd()));
//        commande.setMarchand(marchand);
//        commande.setServiceLivraison(serviceLivraison);
//        commande.setEtat(Etat.EN_ATTENTE);
//
//        return commandeRepository.save(commande);
        return null;
    }

    @Override
    public Commande setLivreurCommande(Long idCom, Long idLivreur) {
        Livreur livreur= livreurRepository.findById(idLivreur).get();
        Commande commande=commandeRepository.findById(idCom).get();
        //email au livreur
        commande.setLivreur(livreur);
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateEtat(Long idCom, String etat) {

        //email si marchand pour l'état de sa commande
        Commande commande= commandeRepository.findById(idCom).get();
        Etat etat1=Etat.fromJsonString(etat);

       commande.setEtat(etat1);


        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommandeById(Long id) {
        commandeRepository.deleteById(id);

    }
}

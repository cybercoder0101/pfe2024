package com.pfe.code.services.impl;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;
import com.pfe.code.entities.Role;
import com.pfe.code.repositories.FournisseurRepository;
import com.pfe.code.services.Exceptions.GlobalException;
import com.pfe.code.services.FourniseurService;
import com.pfe.code.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FourniseurServiceImpl implements FourniseurService {
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Autowired
    ProduitService produitService;



    @Override
    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        fournisseur.setProduits(new ArrayList<Produit>());
        fournisseur.setRole(Role.FOURNISSEUR);
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur getByid(Long id)  {
        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(id);
        if (fournisseur.isEmpty()) {
            throw new GlobalException("Fournisseur with ID " + id + " not found");
        }

        return fournisseurRepository.findById(id).get();
    }

    @Override
    public List<Fournisseur> findByAdresse_Pays(String pays) {
        return fournisseurRepository.findByAdresse_Pays(pays);
    }

    @Override
    public List<Fournisseur> getByNomContains(String nom) {
        return fournisseurRepository.findByNomContains(nom);
    }

    @Override
    public List<Fournisseur> getByNomACS() {
return fournisseurRepository.trierOrderByNomASC();
    }

    @Override
    public List<Fournisseur> getByNomDESC() {
        return fournisseurRepository.trierOrderByNomDESC();
    }

    @Override
    public List<Fournisseur> getByPreAcs() {
        return fournisseurRepository.trierOrderByPreASC();
    }

    @Override
    public Optional<Fournisseur> findByEmail(String email) {
        return fournisseurRepository.findByEmail(email);
    }

    @Override
    public List<Fournisseur> getByPreDesc() {
        return fournisseurRepository.trierOrderByPreDESC();
    }



    @Override
    public void deleteFournisseurById(Long id) {
        fournisseurRepository.deleteById(id);

    }



    @Override
    public Fournisseur updateinfoFour(Long id, Fournisseur fournisseurUp) {
        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(id);
        if (fournisseur.isEmpty()) {
            throw new GlobalException("Fournisseur not found");

        }
        else {
            fournisseur.get().setNom(fournisseurUp.getNom());
            fournisseur.get().setPrenom(fournisseurUp.getPrenom());
            fournisseur.get().setDescription(fournisseurUp.getDescription());
            fournisseur.get().setTelephone(fournisseurUp.getTelephone());
           fournisseur.get().setAdresse(fournisseurUp.getAdresse());
            return fournisseurRepository.save(fournisseur.get());
        }


    }

    @Override
    public Fournisseur updateFourbyid(Long id, Produit produit) {
        Optional<Fournisseur> optionalFournisseur= fournisseurRepository.findById(id);
        if (optionalFournisseur.isPresent()){
            Fournisseur fournisseur= optionalFournisseur.get();
            List<Produit> produits= fournisseur.getProduits();
            produits.add(produit);
            produit.setFournisseur(fournisseur);
            return fournisseurRepository.save(fournisseur);
        }
        return null;
    }


}
